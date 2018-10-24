package com.jby.money.base.rxjava;

import com.binding.model.data.exception.ApiException;
import com.binding.model.data.exception.TokenExpireException;
import com.jby.money.ui.Constant;
import com.union.bangbang.zero.util.InfoEntity;


import org.json.JSONException;

import java.net.ConnectException;
import java.util.ServiceConfigurationError;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.HttpException;

/**
 * Created by Zane on 16/4/9.
 * 更优雅的转换Observable去统一处理错误
 */
public class ErrorTransform<T> implements ObservableTransformer<T, T> {
    private int code = 1;
    private String errorMessage = "";
    private InfoEntity entity;
    @Override
    public ObservableSource<T> apply(Observable<T> upstream) {
        return upstream
                .subscribeOn(Schedulers.io())
                .onErrorResumeNext(this::onThrowable)
                .flatMap(this::flat);
    }


    private ObservableSource<T> flat(T t) {
        if (t instanceof InfoEntity) {
            entity = (InfoEntity) t;
            return Observable.create(this::create);
        }
        return Observable.just(t);
    }

    private void create(ObservableEmitter<T> emitter) {

        try {
            switch (entity.getCode()) {
                case Constant.success: emitter.onNext((T) entity);break;
                default: throw new ApiException(entity.getMsg(), entity.getCode());
            }
        }catch (Exception e){
            emitter.onError(e);
        }finally {
            emitter.onComplete();
        }
    }


    private Observable<T> onThrowable(Throwable throwable){
        if (throwable instanceof HttpException) {
            HttpException response = (HttpException) throwable;
            switch (code = response.code()) {
                case 401: errorMessage = "token无效" + response.message();break;
                case 402: errorMessage = "数据库连接错误" + response.message();break;
                case 403: errorMessage = "无记录" + response.message();break;
                case 405: errorMessage = "token无效" + response.message();break;
                case 400: errorMessage = "参数为空" + response.message();break;
                default: errorMessage = "未知错误" + response.message();break;
            }
            throw new ApiException(errorMessage, code);
        } else if (throwable instanceof ServiceConfigurationError) {
            throw new ApiException("服务器错误",0);
        } else if (throwable instanceof JSONException) {
            throw new ApiException("数据解析错误",0);
        } else if (throwable instanceof ConnectException){
            throw new ApiException("未能连接到对应服务器",0);
        }
        return Observable.error(throwable);
    }
}

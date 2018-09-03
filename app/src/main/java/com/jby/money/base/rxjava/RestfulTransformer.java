package com.jby.money.base.rxjava;


import com.jby.money.base.util.InfoEntity;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;

/**
 * project：cutv_ningbo
 * description：
 * create developer： admin
 * create time：11:22
 * modify developer：  admin
 * modify time：11:22
 * modify remark：
 *
 * @version 2.0
 */


public class RestfulTransformer<T> implements ObservableTransformer<InfoEntity<T>, T> {
    private InfoEntity<T> entity;

    @Override
    public ObservableSource<T> apply(Observable<InfoEntity<T>> upstream) {
        return upstream
                .compose(new ErrorTransform<>())
                .flatMap(this::flat);
    }

    private ObservableSource<? extends T> flat(InfoEntity<T> tInfoEntity) {
        this.entity = tInfoEntity;
        return Observable.create(this::create);
    }

    private void create(ObservableEmitter<T> subscriber) {
        try {
            if (entity.getData() != null)subscriber.onNext(entity.getData());
        } catch (Exception e) {
            subscriber.onError(e);
        } finally {
            subscriber.onComplete();
        }
    }
}

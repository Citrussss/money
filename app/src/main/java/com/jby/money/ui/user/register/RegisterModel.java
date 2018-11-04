package com.jby.money.ui.user.register;


import android.os.Bundle;
import android.view.View;

import com.binding.model.model.ModelView;
import com.binding.model.model.ViewModel;
import com.jby.money.R;
import com.jby.money.base.utils.FunnyToast;
import com.jby.money.databinding.ActivityRegisterBinding;
import com.jby.money.independent.rx.compose.ErrorTransformer;
import com.jby.money.inject.data.api.Api;
import com.jby.money.inject.data.api.ApiInfoEntity;
import com.jby.money.inject.data.sql.InfoEntity;
import com.jby.money.ui.user.UserEntity;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.disposables.Disposable;

/**
 * @name money
 * @class name：com.jby.money.ui.user.register
 * @class describe
 * @anthor bangbang QQ:740090077
 * @time 2018/10/17 9:00 PM
 * @change
 * @chang time
 * @class describe
 */
@ModelView(R.layout.activity_register)
public class RegisterModel extends ViewModel<RegisterActivity,ActivityRegisterBinding> {
    @Inject RegisterModel(){}
    private UserEntity userEntity;
    @Inject
    Api api;
    @Override
    public void attachView(Bundle savedInstanceState, RegisterActivity activity) {
        super.attachView(savedInstanceState, activity);
        userEntity=new UserEntity();
        getDataBinding().setParams(userEntity);
    }
    public void onRigisterClick(View view){
        Disposable subscribe = api.register(userEntity)
                .compose(new ErrorTransformer<>())
                .subscribe(FunnyToast::message, FunnyToast::error);
    }
}

package com.jby.money.ui.user.login;


import android.os.Bundle;
import android.view.View;

import com.binding.model.cycle.MainLooper;
import com.binding.model.model.ModelView;
import com.binding.model.model.ViewHttpModel;
import com.binding.model.model.ViewModel;
import com.binding.model.util.BaseUtil;
import com.jby.money.R;
import com.jby.money.base.arouter.ArouterUtil;
import com.jby.money.base.rxjava.RestfulTransformer;
import com.jby.money.base.util.audiorecord.LToast;
import com.jby.money.databinding.ActivityLoginBinding;
import com.jby.money.inject.data.api.Api;
import com.jby.money.inject.data.sql.DatabaseApi;
import com.jby.money.ui.user.UserEntity;

import javax.inject.Inject;

import io.reactivex.Scheduler;
import io.reactivex.android.MainThreadDisposable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import timber.log.Timber;

import static com.jby.money.inject.component.ActivityComponent.Router.home;
import static com.jby.money.inject.component.ActivityComponent.Router.rigister;

/**
 * @name money
 * @class name：com.jby.money.ui.user.login
 * @class describe
 * @anthor bangbang QQ:740090077
 * @time 2018/10/4 12:45 PM
 * @change
 * @chang time
 * @class describe
 */
@ModelView(R.layout.activity_login)
public class LoginModel extends ViewHttpModel<LoginActivity, ActivityLoginBinding, UserEntity> {
    @Inject
    LoginModel() {
    }

    public String loginBg = "http://kk.51.com/refer?url=https://mmbiz.qpic.cn/mmbiz_gif/BOeKkc9wvYe92nLf0lTPMMLNmZP3gWK5iaDTZoQWcveThSk4XfWAia7QpmArbiaX0V1NiaWF027OKPMLU8mdmiaDKEg/640?wx_fmt=gif";
    @Inject
    Api api;

    @Override
    public void attachView(Bundle savedInstanceState, LoginActivity loginActivity) {
        super.attachView(savedInstanceState, loginActivity);
    }

    public void onLoginClick(View view) {
//        ArouterUtil.navigation(home);
        addDisposable(api.login()
                .compose(new RestfulTransformer<>())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((userEntity -> getDataBinding().setParams(userEntity.get(0))),LToast::error));
    }

    public void onRegisterClick(View view) {
        ArouterUtil.navigation(rigister);
    }


    @Override
    public void onNext(UserEntity userEntity) {

    }
}

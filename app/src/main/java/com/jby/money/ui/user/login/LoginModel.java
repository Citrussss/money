package com.jby.money.ui.user.login;


import android.os.Bundle;
import android.view.View;

import com.binding.model.model.ModelView;
import com.binding.model.model.ViewModel;
import com.jby.money.R;
import com.jby.money.base.arouter.ArouterUtil;
import com.jby.money.databinding.ActivityLoginBinding;

import javax.inject.Inject;

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
public class LoginModel extends ViewModel<LoginActivity,ActivityLoginBinding> {
    @Inject LoginModel(){}
    public String loginBg="http://kk.51.com/refer?url=https://mmbiz.qpic.cn/mmbiz_gif/BOeKkc9wvYe92nLf0lTPMMLNmZP3gWK5iaDTZoQWcveThSk4XfWAia7QpmArbiaX0V1NiaWF027OKPMLU8mdmiaDKEg/640?wx_fmt=gif";
    @Override
    public void attachView(Bundle savedInstanceState, LoginActivity loginActivity) {
        super.attachView(savedInstanceState, loginActivity);
    }
    public void onLoginClick(View view){
        ArouterUtil.navigation(home);
    }
    public void onRegisterClick(View view){
        ArouterUtil.navigation(rigister);
    }
}

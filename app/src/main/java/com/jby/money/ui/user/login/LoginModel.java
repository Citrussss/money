package com.jby.money.ui.user.login;


import android.os.Bundle;

import com.binding.model.model.ModelView;
import com.binding.model.model.ViewModel;
import com.jby.money.R;
import com.jby.money.databinding.ActivityLoginBinding;

import javax.inject.Inject;

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
    @Override
    public void attachView(Bundle savedInstanceState, LoginActivity loginActivity) {
        super.attachView(savedInstanceState, loginActivity);
    }
}

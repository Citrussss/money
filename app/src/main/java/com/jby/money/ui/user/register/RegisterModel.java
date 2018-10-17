package com.jby.money.ui.user.register;


import android.os.Bundle;

import com.binding.model.model.ModelView;
import com.binding.model.model.ViewModel;
import com.jby.money.R;
import com.jby.money.databinding.ActivityRegisterBinding;

import javax.inject.Inject;

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

    @Override
    public void attachView(Bundle savedInstanceState, RegisterActivity activity) {
        super.attachView(savedInstanceState, activity);
    }
}

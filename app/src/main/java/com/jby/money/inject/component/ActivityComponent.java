package com.jby.money.inject.component;


import com.jby.money.inject.module.ActivityModule;
import com.jby.money.inject.scope.ActivityScope;
import com.jby.money.ui.home.HomeActivity;
import com.jby.money.ui.startup.StartUpActivity;
import com.jby.money.ui.user.login.LoginActivity;
import com.jby.money.ui.user.register.RegisterActivity;

import dagger.Component;

/**
 * project：cutv_ningbo
 * description：
 * create developer： admin
 * create time：14:28
 * modify developer：  admin
 * modify time：14:28
 * modify remark：
 *
 * @version 2.0
 */
@ActivityScope
@Component(dependencies = AppComponent.class, modules = {ActivityModule.class})
public interface ActivityComponent {
    void inject(StartUpActivity activity);
    void inject(HomeActivity activity);
    void inject(LoginActivity activity);
    void inject(RegisterActivity activity);
    interface Router {
        String main = "/main/";
        String user = "/user/";
        String startup = main + "startup";
        String home = main + "home";
        String login = user+"login";
        String rigister = user +"register";
        String image = main +"image";
//        String sensor = main +"sensor";
    }
}

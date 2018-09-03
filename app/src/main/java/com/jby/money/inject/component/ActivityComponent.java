package com.jby.money.inject.component;


import com.jby.money.inject.module.ActivityModule;
import com.jby.money.inject.scope.ActivityScope;
import com.jby.money.ui.startup.StartUpActivity;

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

    interface Router {
        String main = "/main/";
        String startup = main + "startup";
    }
}

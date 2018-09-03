package com.jby.money.inject.component;



import com.jby.money.inject.module.ActivityModule;
import com.jby.money.inject.scope.ActivityScope;

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
    interface Router {

    }
}

package com.jby.money.inject.component;

import android.content.Context;

import com.alibaba.sdk.android.oss.OSSClient;
import com.jby.money.inject.data.api.Api;
import com.jby.money.inject.module.AppModule;
import com.jby.money.inject.module.NetWorkModule;
import com.jby.money.inject.qualifier.context.AppContext;
import com.jby.money.inject.scope.ApplicationScope;
import com.jby.money.ui.MoneyApplication;

import dagger.Component;

/**
 * project：cutv_ningbo
 * description：
 * create developer： admin
 * create time：10:08
 * modify developer：  admin
 * modify time：10:08
 * modify remark：
 *
 * @version 2.0
 */

@ApplicationScope
@Component(modules={AppModule.class, NetWorkModule.class})
public interface AppComponent {
    @AppContext
    Context context();
    Api getApi();
    void inject(MoneyApplication application);
}

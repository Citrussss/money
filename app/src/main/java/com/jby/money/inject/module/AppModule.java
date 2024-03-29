package com.jby.money.inject.module;

import android.content.Context;
import android.content.res.Resources;

import com.jby.money.inject.qualifier.context.AppContext;
import com.jby.money.inject.scope.ApplicationScope;
import com.jby.money.ui.MoneyApplication;

import dagger.Module;
import dagger.Provides;

/**
 * project：cutv_ningbo
 * description：
 * create developer： admin
 * create time：10:10
 * modify developer：  admin
 * modify time：10:10
 * modify remark：
 *
 * @version 2.0
 */
@Module
public class AppModule {
    private final MoneyApplication app;
    public AppModule(MoneyApplication app) {
        this.app = app;
    }


    @AppContext
    @ApplicationScope
    @Provides
    Context getApplicationContext() {
        return app;
    }

    @Provides
    @ApplicationScope
    Resources provideResources() {
        return app.getResources();
    }
}

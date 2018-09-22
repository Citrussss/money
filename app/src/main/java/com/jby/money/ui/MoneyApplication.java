package com.jby.money.ui;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;
import com.jby.money.BuildConfig;
import com.jby.money.inject.component.AppComponent;
import com.jby.money.inject.component.DaggerAppComponent;
import com.jby.money.inject.module.AppModule;

public class MoneyApplication extends Application {
    private static AppComponent appComponent;
    private static MoneyApplication application;


    public static AppComponent getAppComponent() {
        return appComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
        appComponent.inject(this);
        initARouter();
    }

    private void initARouter(){
        if (BuildConfig.DEBUG) {
            ARouter.openLog();
            ARouter.openDebug();
        }
        ARouter.init(this);
    }
}

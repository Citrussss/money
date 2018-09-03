package com.jby.money.ui;

import android.app.Application;

import com.jby.money.inject.component.AppComponent;

public class MoneyApplication extends Application {
    private static AppComponent appComponent;


    public static AppComponent getAppComponent() {
        return appComponent;
    }
}

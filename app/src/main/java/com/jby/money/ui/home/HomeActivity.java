package com.jby.money.ui.home;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.jby.money.base.cycle.BaseActivity;

import timber.log.Timber;

//@Route(path = ActivityComponent.Router.home)
public class HomeActivity extends BaseActivity<HomeModel> {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        Timber.w("HomeActivity is run!");
        super.onCreate(savedInstanceState);
    }
}

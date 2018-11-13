package com.jby.money.ui.home;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.jby.money.base.cycle.BaseActivity;
import com.jby.money.inject.component.ActivityComponent;


@Route(path = ActivityComponent.Router.home)
public class HomeActivity extends BaseActivity<HomeModel> {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}

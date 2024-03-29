package com.jby.money.base.cycle;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.binding.model.cycle.ActivityContainer;
import com.binding.model.cycle.DataBindingActivity;
import com.binding.model.model.ViewModel;
import com.binding.model.util.ReflectUtil;
import com.jby.money.inject.component.ActivityComponent;
import com.jby.money.inject.component.DaggerActivityComponent;
import com.jby.money.inject.module.ActivityModule;
import com.jby.money.ui.MoneyApplication;

import java.lang.reflect.Method;

import javax.inject.Inject;

/**
 * project：cutv_ningbo
 * description：
 * create developer： admin
 * create time：12:00
 * modify developer：  admin
 * modify time：12:00
 * modify remark：
 *
 * @version 2.0
 */


public abstract class BaseActivity<VM extends ViewModel> extends DataBindingActivity<ActivityComponent> implements ActivityContainer<ActivityComponent> {
    @Inject
    public VM vm;
    private ActivityComponent mActivityComponent;

    @SuppressWarnings("unchecked")
    public View inject(Bundle savedInstanceState, ViewGroup parent, boolean attachToParent) {
        View rootView;
        try {
            Method method = ActivityComponent.class.getDeclaredMethod("inject", getClass());
            ReflectUtil.invoke(method, getComponent(), this);
            rootView = vm.attachContainer(this,parent,attachToParent,savedInstanceState).getRoot();
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(String.format("edit:%1s need to add_friends @Method inject to ActivityComponent", getClass().getSimpleName()));
        }
        return rootView;
    }

    @Override
    public void initToolBar(Toolbar view) {

    }

    @TargetApi(19)
    protected void setTranslucentStatus(boolean on) {
        Window win = getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        if (on) winParams.flags |= bits;
        else winParams.flags &= ~bits;
        win.setAttributes(winParams);
    }

    @Override
    public ActivityComponent getComponent() {
        if (mActivityComponent == null) {
            mActivityComponent = DaggerActivityComponent.builder()
                    .appComponent(MoneyApplication.getAppComponent())
                    .activityModule(new ActivityModule(this))
                    .build();
        }
        return mActivityComponent;
    }

    @Override
    public AppCompatActivity getDataActivity() {
        return this;
    }


    public void onRightClick(View view) {
        vm.onRightClick(view);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        vm.onActivityResult(requestCode, resultCode, data);
    }

}

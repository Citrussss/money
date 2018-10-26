package com.jby.money.independent.ui;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.jby.money.R;
import com.jby.money.independent.annotation.LayoutHelper;
import com.jby.money.independent.base.IBaseActivity;
import com.jby.money.independent.recycler.adapter.IAdapter;
import com.jby.money.inject.component.ActivityComponent;
import com.jby.money.databinding.ActivityIdependBinding;
/**
 * @name money
 * @class name：com.jby.money.independent.ui
 * @class describe
 * @anthor bangbang QQ:740090077
 * @time 2018/10/26 10:08 PM
 * @change
 * @chang time
 * @class describe
 */
@LayoutHelper(value = R.layout.activity_idepend)
@Route(path = ActivityComponent.Router.home)
public class IndependentActivity extends IBaseActivity<ActivityIdependBinding> {
    private String test ="12222";
    public String getTest() {
        return test;
    }
    public void setTest(String test) {
        this.test = test;
    }
    private IAdapter adapter=new IAdapter();
    private LinearLayoutManager layoutManager=new LinearLayoutManager(this);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getDataBinding().recyclerView.setLayoutManager(layoutManager);
        getDataBinding().recyclerView.setAdapter(adapter);

    }
}

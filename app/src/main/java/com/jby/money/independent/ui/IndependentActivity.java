package com.jby.money.independent.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearSnapHelper;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.jby.money.R;
import com.jby.money.databinding.ActivityIdependBinding;
import com.jby.money.independent.annotation.LayoutHelper;
import com.jby.money.independent.base.IBaseActivity;
import com.jby.money.independent.popup.TestPopup;
import com.jby.money.independent.recycler.adapter.IAdapter;
import com.jby.money.independent.recycler.entity.IndependentEntity;
import com.jby.money.independent.recycler.manager.XLayoutManager;
import com.jby.money.inject.component.ActivityComponent;
import com.jzxiang.pickerview.TimePickerDialog;
import com.jzxiang.pickerview.listener.OnDateSetListener;

import java.util.ArrayList;
import java.util.List;

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
public class IndependentActivity extends IBaseActivity<ActivityIdependBinding> implements OnDateSetListener {
    private String test ="12222";
    public String getTest() {
        return test;
    }
    public void setTest(String test) {
        this.test = test;
    }
    private IAdapter<IndependentEntity> adapter=new IAdapter<>();
    private XLayoutManager layoutManager=new XLayoutManager();
    private TestPopup popup;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getDataBinding().recyclerView.setLayoutManager(layoutManager);
        getDataBinding().recyclerView.setAdapter(adapter);
        LinearSnapHelper helper = new LinearSnapHelper();
        helper.attachToRecyclerView(getDataBinding().recyclerView);
        List<IndependentEntity> list=new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(new IndependentEntity("第："+i));
        }
//        ItemTouchHelper helper =new ItemTouchHelper(new SideViewHelper());
//        helper.attachToRecyclerView(getDataBinding().recyclerView);
        adapter.seteList(list);
       /* Disposable subscribe = RxFileViewer.build(this, RxFileViewerFragment.IMAGE).start().subscribe(file -> {
            BaseUtil.toast(this, file.getAbsolutePath());
        });*/
    }


    @Override
    public void onDateSet(TimePickerDialog timePickerView, long millseconds) {

    }
}

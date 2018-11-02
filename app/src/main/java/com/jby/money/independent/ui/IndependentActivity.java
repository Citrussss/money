package com.jby.money.independent.ui;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.binding.model.util.BaseUtil;
import com.jby.money.R;
import com.jby.money.independent.annotation.LayoutHelper;
import com.jby.money.independent.base.IBaseActivity;
import com.jby.money.independent.popup.TestPopup;
import com.jby.money.independent.recycler.adapter.IAdapter;
import com.jby.money.independent.recycler.entity.IndependentEntity;
import com.jby.money.inject.component.ActivityComponent;
import com.jby.money.databinding.ActivityIdependBinding;
import com.union.bangbang.zero.toast.JoJoToast;
import com.union.bangbang.zero.util.photo.RxFileViewer;
import com.union.bangbang.zero.util.photo.RxFileViewerFragment;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

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
    private IAdapter<IndependentEntity> adapter=new IAdapter<>();
    private LinearLayoutManager layoutManager=new LinearLayoutManager(this);
    private TestPopup popup;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getDataBinding().recyclerView.setLayoutManager(layoutManager);
        getDataBinding().recyclerView.setAdapter(adapter);
        List<IndependentEntity> list=new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(new IndependentEntity("第："+i));
        }
        adapter.seteList(list);
        popup=new TestPopup(this);
        popup.showPopupWindow();
       /* Disposable subscribe = RxFileViewer.build(this, RxFileViewerFragment.IMAGE).start().subscribe(file -> {
            BaseUtil.toast(this, file.getAbsolutePath());
        });*/
    }
}

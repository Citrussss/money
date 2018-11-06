package com.jby.money.ui.home;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.view.MenuItem;

import com.binding.model.adapter.pager.FragmentAdapter;
import com.binding.model.layout.pager.PagerModel;
import com.binding.model.model.ModelView;
import com.jby.money.R;
import com.jby.money.databinding.ActivityHomeBinding;
import com.jby.money.inject.qualifier.manager.ActivityFragmentManager;

import javax.inject.Inject;

import io.reactivex.Observable;

@ModelView(R.layout.activity_home)
public class HomeModel extends PagerModel<HomeActivity, ActivityHomeBinding, HomeEntity>  {
    @Inject
    HomeModel(@ActivityFragmentManager FragmentManager fragmentManager) {
        super(new FragmentAdapter<>(fragmentManager));
    }

    @Override
    public void attachView(Bundle savedInstanceState, HomeActivity activity) {
        super.attachView(savedInstanceState, activity);
        getDataBinding().tabLayout.setupWithViewPager(getDataBinding().viewPager);
        setRcHttp((offset1, refresh) -> Observable.range(0, 3)
                .map(i -> new HomeEntity())
                .toList()
                .toObservable()
        );
//        s.getPageTitle()
    }

}

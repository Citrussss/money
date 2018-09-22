package com.jby.money.ui.home;

import android.view.ViewGroup;

import com.binding.model.model.ViewParse;
import com.binding.model.model.inter.Item;
import com.jby.money.base.cycle.BaseFragment;
import com.jby.money.ui.home.calendar.CalendarFragment;
import com.jby.money.ui.home.record.RecordFragment;
import com.jby.money.ui.home.sensor.SensorFragment;

public class HomeEntity extends ViewParse implements Item<BaseFragment> {
    private BaseFragment fragment;

    @Override
    public BaseFragment getItem(int position, ViewGroup container) {
        if (fragment == null)
            switch (position) {
                case 0: fragment = new RecordFragment();break;
                case 1: fragment = new CalendarFragment();break;
                case 2: fragment = new SensorFragment();break;
            }
        return fragment;
    }
}

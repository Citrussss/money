package com.jby.money.inject.component;

import com.jby.money.inject.module.FragmentModule;
import com.jby.money.inject.scope.FragmentScope;
import com.jby.money.ui.home.calendar.CalendarFragment;
import com.jby.money.ui.home.record.RecordFragment;

import dagger.Component;


/**
 * project：cutv_ningbo
 * description：
 * create developer： admin
 * create time：11:29
 * modify developer：  admin
 * modify time：11:29
 * modify remark：
 *
 * @version 2.0
 */

@FragmentScope
@Component(dependencies = AppComponent.class,modules={FragmentModule.class})
public interface FragmentComponent {
    void inject(RecordFragment fragment);
    void inject(CalendarFragment fragment);
}

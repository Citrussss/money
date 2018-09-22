package com.jby.money.ui.home.calendar;

import android.os.Bundle;

import com.binding.model.layout.recycler.RecyclerModel;
import com.binding.model.model.ModelView;
import com.jby.money.R;
import com.jby.money.databinding.FragmentCalendarBinding;
import com.jby.money.inject.data.sql.JournalEntity;

import javax.inject.Inject;

@ModelView(R.layout.fragment_calendar)
public class CalendarModel extends RecyclerModel<CalendarFragment, FragmentCalendarBinding, JournalEntity> {
    @Inject
    CalendarModel() {
    }


    @Override
    public void attachView(Bundle savedInstanceState, CalendarFragment fragment) {
        super.attachView(savedInstanceState, fragment);
    }

}

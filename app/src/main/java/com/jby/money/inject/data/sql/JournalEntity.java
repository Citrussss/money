package com.jby.money.inject.data.sql;

import android.content.Context;
import android.databinding.ObservableField;
import android.databinding.ViewDataBinding;
import android.text.Editable;
import android.view.View;
import android.view.ViewGroup;

import com.binding.model.model.ModelView;
import com.jby.money.R;
import com.jby.money.base.util.JimUtils;
import com.jby.money.inject.module.DataModule;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;

import timber.log.Timber;

@Table(database = DataModule.class)
@ModelView(R.layout.holder_journal)
public class JournalEntity extends ViewDbInflate {

    @PrimaryKey(autoincrement = true)
    @Column
    private int id;
    @Column
    private long currentTimeMillis;
    @Column
    private String describe;
    @Column
    int money;
    public transient ObservableField<String> yearOb = new ObservableField<>("");
    public transient ObservableField<String> monthOb = new ObservableField<>("");
    public transient ObservableField<String> dayOb = new ObservableField<>("");
    public transient ObservableField<String> moneyOb = new ObservableField<>("");

    @Override
    public ViewDataBinding attachView(Context context, ViewGroup co, boolean attachToParent, ViewDataBinding binding) {
        ViewDataBinding dataBinding = super.attachView(context, co, attachToParent, binding);
        setTime(JimUtils.getStringTime(currentTimeMillis));
        return dataBinding;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public long getCurrentTimeMillis() {
        return currentTimeMillis;
    }

    public void setCurrentTimeMillis(long currentTimeMillis) {
        this.currentTimeMillis = currentTimeMillis;
        setTime(JimUtils.getStringTime(this.currentTimeMillis));
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public void onSaveClick(View view) {

        if (this.update() || this.save()) Timber.i("保存成功");

    }

    public void afterTextChanged(Editable s) {
        setTime(JimUtils.getRightTime(yearOb.get() + "-" + monthOb.get() + "-" + dayOb.get()));
        try {
            money = Integer.parseInt(moneyOb.get());
        } catch (Exception e) {
            moneyOb.set(String.valueOf(money));
        }
    }

    private void setTime(String time) {
        String[] date = time.split(" ")[0].split("-");
        yearOb.set(date[0]);
        monthOb.set(date[1]);
        dayOb.set(date[2]);
    }
}

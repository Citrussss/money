package com.jby.money.independent.recycler.entity;

import android.graphics.drawable.Drawable;
import android.os.Build;

import com.jby.money.R;
import com.jby.money.base.utils.FunnyToast;
import com.jby.money.independent.annotation.LayoutHelper;
import com.jby.money.independent.base.IBaseEntity;
import com.union.bangbang.zero.AppUtil;

/**
 * @name money
 * @class name：com.jby.money.independent.ui
 * @class describe
 * @anthor bangbang QQ:740090077
 * @time 2018/10/26 10:42 PM
 * @change
 * @chang time
 * @class describe
 */
@LayoutHelper(value = {R.layout.holder_idepend, R.layout.holder_fuck})
public class IndependentEntity extends IBaseEntity {
    static int i = 0;
    private String test;
    private String url = "https://uploadbeta.com/api/pictures/random/?key=%E6%8E%A8%E5%A5%B3%E9%83%8E";
    private int id = (int) i;

    public IndependentEntity() {
    }

    public IndependentEntity(String test) {
        this.test = test;
    }

    @Override
    public int getIndexOfView() {
        return getColor();

    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public String getUrl() {
        getColor();
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getColor() {
        return i = i == 0 ? 1 : 0;
    }
}

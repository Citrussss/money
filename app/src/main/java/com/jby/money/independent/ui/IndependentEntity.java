package com.jby.money.independent.ui;

import com.jby.money.R;
import com.jby.money.independent.annotation.LayoutHelper;
import com.jby.money.independent.base.IBaseEntity;

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
@LayoutHelper(value = R.layout.holder_idepend)
public class IndependentEntity  extends IBaseEntity {
    private String test;

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }
}

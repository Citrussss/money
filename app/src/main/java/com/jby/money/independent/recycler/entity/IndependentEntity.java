package com.jby.money.independent.recycler.entity;

import com.jby.money.R;
import com.jby.money.base.utils.FunnyToast;
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
@LayoutHelper(value ={ R.layout.holder_idepend,R.layout.holder_fuck})
public class IndependentEntity  extends IBaseEntity {
    private String test;
    private int id=(int)(Math.random()*2);;
    public IndependentEntity() {
    }

    public IndependentEntity(String test) {
        this.test = test;
    }

    @Override
    public int getIndexOfView() {
        return id;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }
}

package com.jby.money.base.utils;

import android.os.Looper;

import com.binding.model.App;
import com.binding.model.util.BaseUtil;
import com.sdsmdg.tastytoast.TastyToast;
import com.union.bangbang.zero.ActivityManager;

/**
 * @name money
 * @class name：com.jby.money.base.utils
 * @class describe
 * @anthor bangbang QQ:740090077
 * @time 2018/10/24 10:06 PM
 * @change
 * @chang time
 * @class describe
 */
public class FunnyToast extends TastyToast {
    public static void error(Throwable e) {
        new Thread() {
            public void run() {
                Looper.prepare();
                makeText(ActivityManager.getInstance().peekActivity(), e.toString(), TastyToast.LENGTH_LONG, TastyToast.ERROR);
                Looper.loop();
            }
        }.start();
        BaseUtil.toast("");
    }
    public static void message(Object o) {
        new Thread() {
            @Override
            public void run() {
                Looper.prepare();
                TastyToast.makeText(ActivityManager.getInstance().peekActivity(), o.toString(), TastyToast.LENGTH_LONG, TastyToast.INFO);
                Looper.loop();
            }
        }.start();
    }
}

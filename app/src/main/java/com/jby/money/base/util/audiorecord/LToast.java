package com.jby.money.base.util.audiorecord;

import android.os.Looper;

import com.binding.model.App;
import com.sdsmdg.tastytoast.TastyToast;

/**
 * @name money
 * @class name：com.jby.money.base.util.audiorecord
 * @class describe
 * @anthor bangbang QQ:740090077
 * @time 2018/10/20 8:41 PM
 * @change
 * @chang time
 * @class describe
 */
public class LToast {
    public static void error(Throwable e) {
        new Thread() {
            public void run() {
                Looper.prepare();
                TastyToast.makeText(App.getCurrentActivity(), e.toString(), TastyToast.LENGTH_LONG, TastyToast.ERROR);
                Looper.loop();
            }
        }.start();
    }

}

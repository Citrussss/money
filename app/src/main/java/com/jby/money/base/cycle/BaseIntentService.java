package com.jby.money.base.cycle;

import android.app.IntentService;

import com.binding.model.util.ReflectUtil;
import com.jby.money.inject.component.DaggerServiceComponent;
import com.jby.money.inject.component.ServiceComponent;
import com.jby.money.ui.MoneyApplication;

import java.lang.reflect.Method;

/**
 * Created by pc on 2017/9/14.
 */

public abstract class BaseIntentService extends IntentService {
    private ServiceComponent component;

    public BaseIntentService(String name) {
        super(name);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

    private void init(){
        try {
            Method method = ServiceComponent.class.getDeclaredMethod("inject", getClass());
            ReflectUtil.invoke(method, getComponent(), this);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public ServiceComponent getComponent() {
        if (component == null) {
            component = DaggerServiceComponent.builder()
                    .appComponent(MoneyApplication.getAppComponent())
                    .build();
        }
        return component;
    }
}

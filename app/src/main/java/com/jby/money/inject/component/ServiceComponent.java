package com.jby.money.inject.component;

/**
 * Created by pc on 2017/9/4.
 */

import com.jby.money.inject.module.ServiceModule;
import com.jby.money.inject.scope.ServiceScope;

import dagger.Component;

@ServiceScope
@Component(dependencies = AppComponent.class, modules = {ServiceModule.class})
public interface ServiceComponent {
//    void inject(UpdateService service);
//    void inject(ResourceService service);
}

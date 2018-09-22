package com.jby.money.ui.startup;


import android.os.Bundle;

import com.binding.model.model.ModelView;
import com.binding.model.model.ViewModel;
import com.jby.money.R;
import com.jby.money.base.arouter.ArouterUtil;
import com.jby.money.databinding.ActivityStartupBinding;

import javax.inject.Inject;

import static com.jby.money.inject.component.ActivityComponent.Router.home;

@ModelView(R.layout.activity_startup)
public class StartUpModel extends ViewModel<StartUpActivity, ActivityStartupBinding> {
    @Inject
    StartUpModel() {
    }

    @Override
    public void attachView(Bundle savedInstanceState, StartUpActivity activity) {
        super.attachView(savedInstanceState, activity);
//        Intent intent = new Intent();
//        intent.setClass(getT(), HomeActivity.class);
//        getT().startActivity(intent);
        ArouterUtil.navigation(home);
        finish();
    }
}

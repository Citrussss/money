package com.jby.money.ui.home.sensor;

import com.jby.money.base.cycle.BaseFragment;


public class SensorFragment extends BaseFragment<SensorModel> {

    @Override
    public void onPause() {
        super.onPause();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        vm.onDestroy();
    }
}

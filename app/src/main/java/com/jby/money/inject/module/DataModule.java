package com.jby.money.inject.module;

import android.content.Context;

import com.jby.money.inject.data.sql.DatabaseApi;
import com.jby.money.inject.qualifier.context.AppContext;
import com.jby.money.inject.scope.ApplicationScope;
import com.jby.money.ui.Constant;
import com.raizlabs.android.dbflow.annotation.Database;
import com.raizlabs.android.dbflow.config.FlowConfig;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.sql.language.Select;

import dagger.Module;
import dagger.Provides;

/**
 * project：cutv_ningbo
 * description：
 * create developer： admin
 * create time：10:36
 * modify developer：  admin
 * modify time：10:36
 * modify remark：
 *
 * @version 2.0
 */

@Database(name = Constant.NAME, version = Constant.VERSION)
@Module
public class DataModule {

    @Provides
    @ApplicationScope
    DatabaseApi provideSelect(@AppContext Context context){
        FlowConfig flowConfig = new FlowConfig.Builder(context).build();
        FlowManager.init(flowConfig);
        return new DatabaseApi(new Select());
    }


    //    @Migration(version = 2, database = DataModule.class)
//    public static class Migration2 extends BaseMigration {
//        @Override
//        public void migrate(@NonNull DatabaseWrapper database) {
//
//        }
//    }
}

package com.jby.money.inject.data.sql;

import com.raizlabs.android.dbflow.rx2.language.RXSQLite;
import com.raizlabs.android.dbflow.sql.language.Select;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class DatabaseApi {
    Select select;
    public DatabaseApi(Select select) {
        this.select = select;
    }

    public Observable<List<JournalEntity>> getJournalEntity(){
        return RXSQLite.rx(select.from(JournalEntity.class))
                .queryList()
                .subscribeOn(Schedulers.newThread())
                .toObservable();
    }
}

package com.jby.money.inject.data.api;


import com.jby.money.base.util.InfoEntity;
import com.jby.money.ui.user.UserEntity;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by arvin on 2017/11/28.
 */

public interface Api {

    @GET("/login")
    Observable<InfoEntity<List<UserEntity>>> login();
}

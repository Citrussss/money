package com.jby.money.inject.data.api;



import com.jby.money.ui.user.UserEntity;
import com.union.bangbang.zero.util.InfoEntity;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by arvin on 2017/11/28.
 */

public interface Api {

    @GET("/user/login")
    Observable<InfoEntity<List<UserEntity>>> login();
    @POST("/user/register")
    Observable<InfoEntity<UserEntity>> register(@Body UserEntity userEntity);
}

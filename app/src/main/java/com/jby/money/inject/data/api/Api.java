package com.jby.money.inject.data.api;


import com.jby.money.ui.user.UserEntity;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by arvin on 2017/11/28.
 */

public interface Api {

    @POST("/user/login")
    Observable<ApiInfoEntity<UserEntity>> login(@Body UserEntity userEntity);
    @POST("/user/register")
    Observable<ApiInfoEntity<UserEntity>> register(@Body UserEntity userEntity);
}

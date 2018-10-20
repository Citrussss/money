package com.jby.money.inject.data.api;


import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by arvin on 2017/11/28.
 */

public interface Api {

    @GET("/login")
    Observable<String> login();
}

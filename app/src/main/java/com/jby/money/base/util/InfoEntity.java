package com.jby.money.base.util;

import com.binding.model.data.entity.BaseEntity;

/**
 * project：cutv_ningbo
 * description：
 * create developer： admin
 * create time：14:58
 * modify developer：  admin
 * modify time：14:58
 * modify remark：
 *
 * @version 2.0
 */

public class InfoEntity<T> extends BaseEntity {

    /**
     * error_code : 0
     * data : eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwOi8vbG9jYWwuYm9vay5jb20vYy9hdXRoL2FjY291bnQtcmVnaXN0ZXIiLCJpYXQiOjE0OTg0Njg0MzgsImV4cCI6MTUwMTA2MDQzOCwibmJmIjoxNDk4NDY4NDM4LCJqdGkiOiJTcU8yNHFNbWJ1OWZwSmRaIiwic3ViIjoxLCJ1c2VyIjp7ImlkIjoxfX0.54yRgd6KKPpwli2JhrVW7e6QAjQ4qIgpUca74pw6i2o
     * message : null
     */

    private int code;
    private T data;
    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int code() {
//        TextUtils.isDigitsOnly()
        return code;
    }
}

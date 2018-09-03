package com.jby.money.base.util;

public interface JpushIdType {
    int userIdType = 0;
    int groupIdType = 1;

    int getIdType();

    int getId();
}

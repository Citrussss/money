package com.jby.money.base.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class JimUtils {

    private final static SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd", new Locale("cn"));

    public static String getRightTime(String time) {
        try {
            return dateformat.format(dateformat.parse(time).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return time;
    }

    public static String getStringTime(long currentTimeMillis) {
        return dateformat.format(currentTimeMillis);
    }

    public static String getNowTime() {
        return getStringTime(System.currentTimeMillis());
    }
}

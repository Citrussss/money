package com.jby.money.base.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class TimeUtil {
    private static long zeroToday = 0;//当日凌晨 00：00
    private static long twelveToday = 0;//当日最后一刻 23:59
    private static long sevenDaysAgo = 0;//七天之前的 位置
    private static long zeroyestoday = 0; // 昨天0点
    private static long tfHour = 24 * 60 * 60 * 1000;
    private static TimeUtil instance ;

    private TimeUtil() {
        long currentTimeMillis = System.currentTimeMillis();
        zeroToday = currentTimeMillis / (1000 * 3600 * 24) * (1000 * 3600 * 24) - TimeZone.getDefault().getRawOffset();
        twelveToday = zeroToday + tfHour - 1;
        zeroyestoday = zeroToday - tfHour;
        sevenDaysAgo = zeroToday - 7 * tfHour;
    }


    public static TimeUtil getInstant() {
        if (instance == null) {
            instance = new TimeUtil();
        }
        return instance;
    }

    public String strMsgTime(long timeMillis) {
        if (timeMillis > zeroToday) return getHHmmss(timeMillis);
        else if (timeMillis > sevenDaysAgo) return getStringUntilNow(timeMillis);
        else return getDateStr(timeMillis);
    }

    /**
     * HH:mm:ss
     */
    public String getHHmmss(long time) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss", Locale.getDefault());
        long lt = Long.valueOf(String.valueOf(time));
        Date date = new Date(lt);
        return simpleDateFormat.format(date);
    }

    public String getStringUntilNow(long time) {
        int position = 7 - (int) ((time - sevenDaysAgo) / tfHour);
        StringBuffer buffer =new StringBuffer();
        switch (position) {
            case 1:buffer.append("昨天：").append(getHHmmss(time));break;
            case 2:buffer.append("前天").append(getHHmmss(time));break;
            case 3:
            case 4:
            case 5:
            case 6:buffer.append("一周内");
        }
        return buffer.toString();
    }

    /**
     * 获取当前日期是星期几<br>
     *
     * @param date
     * @return 当前日期是星期几
     */
    public String getWeekOfDate(Date date) {
        String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int day = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (day < 0)
            day = 0;
        return weekDays[day];
    }

    public String getWeekOfDate(long time) {
        return getWeekOfDate(getDate(time));
    }

    public Date getDate(long time) {
        long lt = Long.valueOf(String.valueOf(time));
        Date date = new Date(lt);
        return date;
    }

    /**
     * 获得 str 的时间 "yyyy-MM-dd HH:mm:ss"
     *
     * @param time
     * @return
     */
    public String getDateStr(long time) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        return simpleDateFormat.format(getDate(time));
    }
}

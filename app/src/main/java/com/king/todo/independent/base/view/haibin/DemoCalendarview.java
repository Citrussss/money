package com.king.todo.independent.base.view.haibin;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.v4.content.ContextCompat;

import com.haibin.calendarview.Calendar;
import com.haibin.calendarview.MonthView;
import com.jby.money.R;
import com.union.bangbang.zero.AppUtil;

import static com.binding.model.App.getCurrentActivity;

public class DemoCalendarview extends MonthView {
    private Paint textPaint;

    private int indigoBlue;
    private int yellow =0xF4B33F;
    public DemoCalendarview(Context context) {
        super(context);
        initColor();
        initPaint();
    }

    /**
     * 绘制选中的日子
     *
     * @param canvas    canvas
     * @param calendar  日历日历calendar
     * @param x         日历Card x起点坐标
     * @param y         日历Card y起点坐标
     * @param hasScheme hasScheme 非标记的日期
     * @return 返回true 则绘制onDrawScheme，因为这里背景色不是互斥的，所以返回true
     */
    @Override
    protected boolean onDrawSelected(Canvas canvas, Calendar calendar, int x, int y, boolean hasScheme) {
//        canvas.drawText(String.valueOf(calendar.getDay()), x, y, textPaint);
        return false;
    }

    /**
     * 绘制标记的事件日子
     *
     * @param canvas   canvas
     * @param calendar 日历calendar
     * @param x        日历Card x起点坐标
     * @param y        日历Card y起点坐标
     */
    @Override
    protected void onDrawScheme(Canvas canvas, Calendar calendar, int x, int y) {
//        canvas.drawText(String.valueOf(calendar.getDay()), x, y, textPaint);
    }

    /**
     * 绘制文本
     *
     * @param canvas     canvas
     * @param calendar   日历calendar
     * @param x          日历Card x起点坐标
     * @param y          日历Card y起点坐标
     * @param hasScheme  是否是标记的日期
     * @param isSelected 是否选中
     */
    @Override
    protected void onDrawText(Canvas canvas, Calendar calendar, int x, int y, boolean hasScheme, boolean isSelected) {
            int size =Math.min(mItemHeight,mItemWidth);
        canvas.drawArc(x,y,x+size,x+size,0,360,true,textPaint);
        canvas.drawText(String.valueOf(calendar.getDay()), x+mItemWidth/2, y+mItemHeight/2, textPaint);
    }

    private void initPaint() {
        textPaint = new Paint();
        textPaint.setAntiAlias(true);
        textPaint.setTextAlign(Paint.Align.CENTER);
        textPaint.setColor(indigoBlue);
        textPaint.setFakeBoldText(true);
        textPaint.setTextSize(dip2px(AppUtil.peekActivity(), 12));
    }

    private void initColor() {
        indigoBlue = ContextCompat.getColor(AppUtil.peekActivity(), R.color.colorPrimary);
    }

    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}

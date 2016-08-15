package com.atguigu.beijing.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * 作者：尚硅谷-lvjunfeng on 2016/8/15 18:42
 * 微信：825801863
 * QQ号：825801863
 * 作用：让默认的viewpager不可以滑动，替换ContentFragment布局中的viewpager
 */
public class NoScrollViewPager extends ViewPager {
    //在代码中实例化对象的时候调用此方法
    public NoScrollViewPager(Context context) {
        super(context);
    }

    //在布局文件中调用该类时候使用，系统要求必须调用，不然会崩溃
    public NoScrollViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    //重写触摸事件消费掉
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return true;
    }
}

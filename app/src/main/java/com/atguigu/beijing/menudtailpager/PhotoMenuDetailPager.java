package com.atguigu.beijing.menudtailpager;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.atguigu.beijing.base.MenuDtilsBsaePager;
import com.atguigu.beijing.utils.LogUtil;

/**
 * 作者：尚硅谷-lvjunfeng on 2016/8/16 01:15
 * 微信：825801863
 * QQ号：825801863
 * 作用：xxxx
 */
public class PhotoMenuDetailPager extends MenuDtilsBsaePager {
    private TextView textView;
    public PhotoMenuDetailPager(Context context) {
        super(context);
    }

    @Override
    public View initView() {

        textView = new TextView(context);
        textView.setGravity(Gravity.CENTER);

        textView.setTextSize(25);
        textView.setTextColor(Color.RED);
        

        LogUtil.e("专图详情页面被初始化了");
        textView.setText("这是专图详情页面");
        return textView;
    }

    @Override
    public void initData() {
        super.initData();
    }
}

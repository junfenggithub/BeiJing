package com.atguigu.beijing.pager;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.widget.TextView;

import com.atguigu.beijing.base.BasePager;

/**
 * Created by lvjunfeng on 2016/8/15.
 */
public class SmartPager extends BasePager {


    private TextView textView;

    public SmartPager(Context context) {
        super(context);
    }

    @Override
    public void initData() {
        super.initData();
        Log.e("TAG", "这是智慧中心");
        textView = new TextView(context);
        textView.setGravity(Gravity.CENTER);
        textView.setText("这是智慧中心");
        textView.setTextSize(25);
        textView.setTextColor(Color.RED);

        //添加到真布局
        fl_content.addView(textView);

    }
}

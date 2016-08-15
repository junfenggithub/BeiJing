package com.atguigu.beijing.pager;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.TextView;

import com.atguigu.beijing.base.BasePager;
import com.atguigu.beijing.utils.LogUtil;

/**
 * Created by lvjunfeng on 2016/8/15.
 */
public class HomePager extends BasePager {



    private TextView textView;

    public HomePager(Context context) {
        super(context);
    }

    @Override
    public void initData() {
        super.initData();
        //1.设置标题
        tv_title.setText("主页");

        //2.联网请求


        LogUtil.e("主界面被初始化了");
        textView = new TextView(context);
        textView.setGravity(Gravity.CENTER);

        textView.setTextSize(25);
        textView.setTextColor(Color.RED);

        //3.添加到真布局
        fl_content.addView(textView);

        //4.绑定数据
        textView.setText("这是主页面");
    }
}

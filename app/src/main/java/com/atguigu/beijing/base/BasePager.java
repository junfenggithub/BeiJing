package com.atguigu.beijing.base;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import com.atguigu.beijing.R;
import com.atguigu.beijing.activity.MainActivity;

/**
 * Created by lvjunfeng on 2016/8/15.
 * 是HomePager,NewsPager,SmartPager,GovaffairPager,SettingPager的基类
 */
public class BasePager {

    public ImageButton ib_menu;
    public TextView tv_title;
    //加载各个子页面的
    public FrameLayout fl_content;

    public Context context;

    //代表不同的页面
    public View rootView;


    public BasePager(Context context) {
        this.context = context;
        rootView = initView();
    }

    //用于初始化公共部分视图，并且初始化加载子视图的FrameLayout
    public View initView(){
        View view = View.inflate(context, R.layout.basepager,null);
        ib_menu = (ImageButton) view.findViewById(R.id.ib_menu);
        tv_title = (TextView) view.findViewById(R.id.tv_title);
        fl_content = (FrameLayout) view.findViewById(R.id.fl_content);

        //给菜单Imagebutton设置点击事件
        ib_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            //关闭侧滑菜单
                MainActivity mainActivity = (MainActivity) context;
                mainActivity.getSlidingMenu().toggle();//关→开
            }
        });
        return view;
    }

    //当孩子需要请求数据，或者需要动态显示数据的时候重写该方法，此方法在这里面没有被调用实际上是------BasePager是父类
    // 在子类中重写这个方法，但实际上是执行的子类的方法，只要在子类中实现数据的操作加载就行
    public  void initData(){
    }
}

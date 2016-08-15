package com.atguigu.beijing.base;

import android.content.Context;
import android.view.View;

/**
 * 作者：尚硅谷-lvjunfeng on 2016/8/16 01:05
 * 微信：825801863
 * QQ号：825801863
 * 作用：xxxx
 */
public abstract class MenuDtilsBsaePager {

    public final Context context;

    public View rootView;//指的是各个详情页面的视图，因为没有相同的部分所以让各个视图自己去实现（抽象）
    public MenuDtilsBsaePager(Context context) {
        this.context = context;
        rootView = initView();
    }

    //每个页面实现不同的效果
    public abstract View initView();

    //子视图需要绑定数据联网请求数据的时候重写该方法
    public void initData(){

    }


}

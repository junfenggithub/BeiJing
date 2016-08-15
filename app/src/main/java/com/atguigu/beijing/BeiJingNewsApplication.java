package com.atguigu.beijing;

import android.app.Application;

import org.xutils.x;

/**
 * Created by lvjunfeng on 2016/8/15.
 */
public class BeiJingNewsApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(true);
    }
}

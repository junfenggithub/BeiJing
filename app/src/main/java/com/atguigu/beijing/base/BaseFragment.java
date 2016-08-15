package com.atguigu.beijing.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by lvjunfeng on 2016/8/14.
 */
public abstract class BaseFragment extends Fragment {
    public  Context context;

    //Fragment被创建的时候
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context=getActivity();//获取当前activity
    }

    //视图被创建的时候调用
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return initView();
    }
    //让子类视图去实现，已达到自己特定的效果
        public abstract View initView();


    //activity被创建之后调用
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    /**
     * 1.如果自页面没有数据，联网请求数据，并且绑定到initView初始化的视图上
     * 2.绑定到initView初始化的视图上
     * 此方法的目的是为了将界面与界面的数据分离开，体现的是架构的特点，增加了扩展性
     */
    public void initData() {

    }
}

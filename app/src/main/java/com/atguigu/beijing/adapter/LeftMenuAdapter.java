package com.atguigu.beijing.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.atguigu.beijing.R;
import com.atguigu.beijing.domain.NewsCenterPagerBean;
import com.atguigu.beijing.utils.LogUtil;

import java.util.List;

/**
 * 作者：尚硅谷-lvjunfeng on 2016/8/15 22:17
 * 微信：825801863
 * QQ号：825801863
 * 作用：xxxx
 */
public class LeftMenuAdapter extends BaseAdapter {


    private final List<NewsCenterPagerBean.DataBean> data;
    private final int mPosition;
    private final Context mContext;


    public LeftMenuAdapter(Context context,List<NewsCenterPagerBean.DataBean> data,int position){
        this.mContext = context;
        this.mPosition = position;
        LogUtil.e("1111111111111111111"+position);
        this.data = data;
    }
    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView textview = (TextView) View.inflate(mContext, R.layout.item_leftmenu,null);
        textview.setText(data.get(position).getTitle());
        //设置选择颜色
        LogUtil.e(mPosition+"7777777777");
        textview.setEnabled(mPosition==position);

        return textview;
    }

    @Override
    public Object getItem(int position) {
//        return data.get(position);
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


}

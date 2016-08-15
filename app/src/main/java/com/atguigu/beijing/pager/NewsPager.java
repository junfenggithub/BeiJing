package com.atguigu.beijing.pager;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.atguigu.beijing.activity.MainActivity;
import com.atguigu.beijing.base.BasePager;
import com.atguigu.beijing.base.MenuDtilsBsaePager;
import com.atguigu.beijing.domain.NewsCenterPagerBean;
import com.atguigu.beijing.fragment.LeftMenuFragment;
import com.atguigu.beijing.menudtailpager.InteracMenuDetailPager;
import com.atguigu.beijing.menudtailpager.NewsMenuDetailPager;
import com.atguigu.beijing.menudtailpager.PhotoMenuDetailPager;
import com.atguigu.beijing.menudtailpager.TopicMenuDetailPager;
import com.atguigu.beijing.utils.Constants;
import com.atguigu.beijing.utils.LogUtil;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lvjunfeng on 2016/8/15.
 *
 * 
 */
public class NewsPager extends BasePager {


    private TextView textView;
    private List<NewsCenterPagerBean.DataBean> data;
    private ArrayList<MenuDtilsBsaePager> detailsBasePager;

    public NewsPager(Context context) {
        super(context);
    }

    @Override
    public void initData() {
        Log.e("TAG", "这是新闻页面");
        super.initData();
        //设置imagebutton的可见
        ib_menu.setVisibility(View.VISIBLE);


        tv_title.setText("新闻");
        textView = new TextView(context);
        textView.setGravity(Gravity.CENTER);
        textView.setText("新闻页面");
        textView.setTextSize(25);
        textView.setTextColor(Color.RED);

        //添加到真布局
        fl_content.addView(textView);

        //联网请求数据
        getDataFromNet();
    }

    private void getDataFromNet() {

        RequestParams params = new RequestParams(Constants.NEWCENTER_PAGER_URL);
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                //解析josn数据和显示数据
                LogUtil.e("xu3请求成功");
                processData(result);
                //设置适配器
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                LogUtil.e("x3qingqiu失败" + ex);
            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }
        //解析josn数据和显示数据
    private void processData(String json) {
        NewsCenterPagerBean bean = parasedJson(json);
        //String title = bean.getData().get(0).getChildren().get(1).getTitle();
        LogUtil.e("Gosn解析json数据成功");


        //给左侧菜单传递数据
        data = bean.getData();
        //通过mainactivity得到左侧菜单，再讲解析的数据传递给左侧菜单
        MainActivity mainActivity = (MainActivity) context;
        LeftMenuFragment leftMenuFragment = mainActivity.getLeftMenuFragment();


        detailsBasePager = new ArrayList<>();
        detailsBasePager.add(new NewsMenuDetailPager(context));
        detailsBasePager.add(new TopicMenuDetailPager(context));
        detailsBasePager.add(new PhotoMenuDetailPager(context));
        detailsBasePager.add(new InteracMenuDetailPager(context));


        leftMenuFragment.setData(data);




    }
/*
*两种解析方法，1.系统自带API,2.第三方框架json解析
* */
    //解析json
    private NewsCenterPagerBean parasedJson(String json) {
        Gson gson = new Gson();
        NewsCenterPagerBean bean = gson.fromJson(json, NewsCenterPagerBean.class);
        //或者return new Gson().fromJson(json, NewsCenterPagerBean.class);
        return bean;
    }

    public void switchPager(int position) {
        //1.设置标题
        tv_title.setText(data.get(position).getTitle());
        //移除之前内容
        fl_content.removeAllViews();
        //添加新内容
        MenuDtilsBsaePager menuDtilsBsaePager = detailsBasePager.get(position);
        View view = menuDtilsBsaePager.initView();
        menuDtilsBsaePager.initData();
        fl_content.addView(view);


    }
}

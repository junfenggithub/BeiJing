package com.atguigu.beijing;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class GuideActivity extends Activity {
        private ViewPager viewpager;
        private Button bt_start_main;
        private LinearLayout ll_point_group;
        private List<ImageView> imageviews ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        initId();
        initData();
    }

    private void initData() {
        //数据初始化
        int[] ids = new int[]{R.drawable.guide_1,R.drawable.guide_2,R.drawable.guide_3};

        imageviews = new ArrayList<>();


        for(int i = 0;i<ids.length;i++){
            ImageView  image = new ImageView(this);
            image.setImageResource(ids[i]);
            imageviews.add(image);

            //动态创建小点

            ImageView paint = new ImageView(this);
            paint.setBackgroundResource(R.drawable.paint_normal);
           // LinearLayout.LayoutParams params = new ActionMenuView.LayoutParams(10,10);//像素
          //  paint.setLayoutParams(params);
            ll_point_group.addView(paint);

        }

        //设置适配器
        viewpager.setAdapter(new MyAdapter());


    }
    //一个viewPager默认有两个页面，最多有三个，被滑出的界面会被销毁，因为每个界面中有很多的内容，不想Listview相差不大，所以就容易造成内存溢出
    class MyAdapter extends PagerAdapter{

        @Override
        public int getCount() {
            return imageviews.size();
        }
        //container实际上是viewPager，VoewGroup是父类，此回调相当于getView（）
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ImageView images = imageviews.get(position);
            container.addView(images);


            return images;
        }

        //object是instantiateItem的返回的view,这个方法是判断当前视图是不是返回的视图
        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }



        //position 是要销毁的页面的位置，object是销毁的页面
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            // super.destroyItem(container, position, object);
            container.removeView((View) object);
        }


    }

    private void initId() {
        bt_start_main = (Button)findViewById(R.id.bt_start_main);
        viewpager = (ViewPager)findViewById(R.id.viewpager);
        ll_point_group = (LinearLayout)findViewById(R.id.ll_point_group);
    }
}

package com.atguigu.beijing;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.RelativeLayout;

public class SplashActivity extends Activity {
        private RelativeLayout rl_splash_root;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Log.e("TAG", "nihdi");


        rl_splash_root = (RelativeLayout)findViewById(R.id.rl_splash_root);

        //旋转动画,渐变，旋转
        RotateAnimation  ra = new RotateAnimation(0,360,RotateAnimation.RELATIVE_TO_SELF,0.5f,
                RotateAnimation.RELATIVE_TO_SELF,0.5f);

//        ra.setDuration(2000);
        ra.setFillAfter(true);

        AlphaAnimation aa = new AlphaAnimation(0,1);
        aa.setFillAfter(true);
//        aa.setDuration(2000);

        ScaleAnimation sa = new ScaleAnimation(0,1,0,1, ScaleAnimation.RELATIVE_TO_SELF,0.5f,ScaleAnimation.RELATIVE_TO_SELF,0.5f);
//        sa.setDuration(2000);
        sa.setFillAfter(true);

        AnimationSet set = new AnimationSet(false);
        set.setDuration(2000);
        set.addAnimation(ra);
        set.addAnimation(aa);
        set.addAnimation(sa);

        rl_splash_root.startAnimation(set);

        //监听动画播放完成
        set.setAnimationListener(new MyAnimationListener());

    }
    class  MyAnimationListener implements Animation.AnimationListener{

        //动画开始的回调
        @Override
        public void onAnimationStart(Animation animation) {

        }
        //动画结束的回调
        @Override
        public void onAnimationEnd(Animation animation) {
            Intent intent = new Intent(SplashActivity.this,GuideActivity.class);
            startActivity(intent);
            finish();
        }
        //动画重复的回调
        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    }
}

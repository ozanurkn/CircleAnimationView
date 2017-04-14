package com.yusufcakmak.circleview;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/**
 * Created by yusufcakmak on 14/04/2017.
 */

class AnimationUtil implements AnimListener {
    private Context context;
    private Animation rotation;
    private int position = 0;
    private ImageView animationImageView;
    private RelativeLayout parentView;

    AnimationUtil(Context context, ImageView view, RelativeLayout parentView) {
        this.context = context;
        this.parentView = parentView;
        this.animationImageView = view;
        initAnimation();
    }

    private void initAnimation(){
        final int[] icons = {R.drawable.automobile, R.drawable.motor,R.drawable.suv};

        animationImageView.setImageResource(R.drawable.automobile2);
        rotation= AnimationUtils.loadAnimation(context, R.anim.rotate_around_center_point);
        rotation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                if (position == icons.length) {
                    position = 0;
                }
                animationImageView.setImageResource(icons[position]);
                animationImageView.startAnimation(rotation);
                position += 1;

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    @Override
    public void start() {
        animationImageView.startAnimation(rotation);
    }

    @Override
    public void stop() {
        animationImageView.getAnimation().cancel();
        animationImageView.clearAnimation();
        if(rotation != null){
            rotation.setAnimationListener(null);
        }
    }
}

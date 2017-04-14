package com.yusufcakmak.circleview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    private AnimationUtil animationUtil;
    private boolean isAnimationStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RelativeLayout animationLayout = (RelativeLayout) findViewById(R.id.animationLayout);
        ImageView animationView = (ImageView) findViewById(R.id.animationView);
        Button animControlButton = (Button) findViewById(R.id.animControlButton);


        animationUtil = new AnimationUtil(getApplicationContext(), animationView, animationLayout);

        animControlButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isAnimationStart = !isAnimationStart;
                if(isAnimationStart){
                    animationUtil.start();
                } else {
                    animationUtil.stop();
                }
            }
        });

    }
}

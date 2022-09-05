package com.cecom.caukiosk;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends BaseActivity {
    int curBG = 4;
    int tapCnt = 0;

    ImageView imageBg1;
    ImageView imageBg2;
    ImageView imageBg3;
    ImageView imageBg4;

    ImageView EasterEgg;
    ImageView EasterEggView;
    ImageView whiteView;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        overridePendingTransition(0, 0);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialView();

        imageBg1 = findViewById(R.id.main_image_bg_1);
        imageBg2 = findViewById(R.id.main_image_bg_2);
        imageBg3 = findViewById(R.id.main_image_bg_3);
        imageBg4 = findViewById(R.id.main_image_bg_4);

        whiteView = findViewById(R.id.easter_egg_view_white);
        EasterEgg = findViewById(R.id.image_view_main_logo);
        EasterEggView = findViewById(R.id.easter_egg_view);

        EasterEgg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.getId() == R.id.image_view_main_logo){
                    tapCnt++;
                }
                if(tapCnt >= 15){
                    File imgFile = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "club_image" + File.separator, "EasterEgg.png");
                    if(imgFile.exists()){
                        Bitmap bm = BitmapFactory.decodeFile(imgFile.getPath());
                        EasterEggView.setImageBitmap(bm);
                    }

                    whiteView.setVisibility(View.VISIBLE);
                    EasterEggView.setVisibility(View.VISIBLE);
                    KioskModeApp.setIsInLockMode(!KioskModeApp.isInLockMode);
                    enableKioskMode(false);
                }
            }
        });
        imageBg1.setVisibility(View.VISIBLE);
        imageBg2.setVisibility(View.INVISIBLE);
        imageBg3.setVisibility(View.INVISIBLE);
        imageBg4.setVisibility(View.INVISIBLE);

        mBGHandler.sendEmptyMessage(0);
        setUpAdmin();
    }

    Handler mBGHandler = new Handler(){
        @SuppressLint("HandlerLeak")
        public void handleMessage(Message msg){
            switch(curBG){
                case 1:
                    imageBg2.setAlpha(0f);
                    imageBg2.setVisibility(View.VISIBLE);
                    imageBg2.animate()
                            .alpha(1f)
                            .setDuration(500)
                            .setListener(null);

                    imageBg1.animate()
                            .alpha(0f)
                            .setDuration(500)
                            .setListener(new AnimatorListenerAdapter() {
                                @Override
                                public void onAnimationEnd(Animator animation) {
                                    imageBg1.setVisibility(View.INVISIBLE);
                                }
                            });

                    curBG = 2;
                    break;
                case 2:
                    imageBg3.setAlpha(0f);
                    imageBg3.setVisibility(View.VISIBLE);
                    imageBg3.animate()
                            .alpha(1f)
                            .setDuration(500)
                            .setListener(null);

                    imageBg2.animate()
                            .alpha(0f)
                            .setDuration(500)
                            .setListener(new AnimatorListenerAdapter() {
                                @Override
                                public void onAnimationEnd(Animator animation) {
                                    imageBg2.setVisibility(View.INVISIBLE);
                                }
                            });

                    curBG = 3;
                    break;
                case 3:
                    imageBg4.setAlpha(0f);
                    imageBg4.setVisibility(View.VISIBLE);
                    imageBg4.animate()
                            .alpha(1f)
                            .setDuration(500)
                            .setListener(null);

                    imageBg3.animate()
                            .alpha(0f)
                            .setDuration(500)
                            .setListener(new AnimatorListenerAdapter() {
                                @Override
                                public void onAnimationEnd(Animator animation) {
                                    imageBg3.setVisibility(View.INVISIBLE);
                                }
                            });

                    curBG = 4;
                    break;
                case 4:
                    imageBg1.setAlpha(0f);
                    imageBg1.setVisibility(View.VISIBLE);
                    imageBg1.animate()
                            .alpha(1f)
                            .setDuration(500)
                            .setListener(null);

                    imageBg4.animate()
                            .alpha(0f)
                            .setDuration(500)
                            .setListener(new AnimatorListenerAdapter() {
                                @Override
                                public void onAnimationEnd(Animator animation) {
                                    imageBg4.setVisibility(View.INVISIBLE);
                                }
                            });

                    curBG = 1;
                    break;
            }
            mBGHandler.sendEmptyMessageDelayed(0, 10000);
        }
    };

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }
    @Override
    protected void onPause() {
        super.onPause();
        if(KioskModeApp.isInLockMode){
            ActivityManager activityManager = (ActivityManager) getApplicationContext()
                    .getSystemService(Context.ACTIVITY_SERVICE);
            activityManager.moveTaskToFront(getTaskId(), 0);
        }
    }
}
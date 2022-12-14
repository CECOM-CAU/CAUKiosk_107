package com.cecom.caukiosk;

import androidx.appcompat.app.AppCompatActivity;

import android.app.admin.DevicePolicyManager;
import android.content.Intent;
import android.graphics.Typeface;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class BaseActivity extends AppCompatActivity{
    protected DevicePolicyManager mDpm;

    protected void setUpAdmin(){}

    protected void enableKioskMode(boolean enabled){
        try{
            if(enabled){
                if(mDpm.isLockTaskPermitted(this.getPackageName())){
                    KioskModeApp.setIsInLockMode(true);
                    startLockTask();
                }else{
                    KioskModeApp.setIsInLockMode(false);
                    Log.e("Kiosk Mode Error", getString(R.string.kiosk_not_permitted));
                }
            }else{
                KioskModeApp.setIsInLockMode(false);
                stopLockTask();
            }
        }catch(Exception e){
            KioskModeApp.setIsInLockMode(false);
            Log.e("Kiosk Mode Error", e.getMessage());
        }
    }

    void initialView(){
        Typeface typefaceBM;
        typefaceBM = Typeface.createFromAsset(getAssets(), "fonts/SCDreamEB.otf");
        getWindow().getDecorView()
                .setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        Button btnExtDong = findViewById(R.id.main_btn_etc_dong);
        Button btnFloorB2 = findViewById(R.id.main_btn_floor_b2);
        Button btnFloorB1 = findViewById(R.id.main_btn_floor_b1);
        Button btnFloor1 = findViewById(R.id.main_btn_floor_1);
        Button btnFloor2 = findViewById(R.id.main_btn_floor_2);
        Button btnFloor3 = findViewById(R.id.main_btn_floor_3);
        Button btnFloor4 = findViewById(R.id.main_btn_floor_4);
        Button btnFloor5 = findViewById(R.id.main_btn_floor_5);
        Button btnFloor6 = findViewById(R.id.main_btn_floor_6);
        Button gaDong = findViewById(R.id.main_btn_ga_dong);
        Button naDong = findViewById(R.id.main_btn_na_dong);

        final ImageView btnFacility = findViewById(R.id.main_btn_facility);
        ImageView btnHome = findViewById(R.id.main_btn_home);
        ImageView btnSearch = findViewById(R.id.main_btn_search);
        View.OnClickListener btnListener = new View.OnClickListener(){
            @Override
            public void onClick(View view){
                switch(view.getId()){
                    case R.id.main_btn_facility:
                        startActivity(new Intent(getApplicationContext(), TotalViewActivity.class));
                        finish();
                        break;
                    case R.id.main_btn_home:
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        finish();
                        break;
                    case R.id.main_btn_search:
                        startActivity(new Intent(getApplicationContext(), SearchActivity.class));
                        finish();
                        break;

                }
            }
        };

        View.OnClickListener floorListener = new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), FloorActivity.class);
                switch(view.getId()){
                    case R.id.main_btn_etc_dong:
                        intent.putExtra("Floor", "EXT");
                        break;
                    case R.id.main_btn_floor_b2:
                        intent.putExtra("Floor", "B2");
                        break;
                    case R.id.main_btn_floor_b1:
                        intent.putExtra("Floor", "B1");
                        break;
                    case R.id.main_btn_floor_1:
                        intent.putExtra("Floor", "1");
                        break;
                    case R.id.main_btn_floor_2:
                        intent.putExtra("Floor", "2");
                        break;
                    case R.id.main_btn_floor_3:
                        intent.putExtra("Floor", "3");
                        break;
                    case R.id.main_btn_floor_4:
                        intent.putExtra("Floor", "4");
                        break;
                    case R.id.main_btn_floor_5:
                        intent.putExtra("Floor", "5");
                        break;
                    case R.id.main_btn_floor_6:
                        intent.putExtra("Floor", "6");
                        break;

                }
                startActivity(intent);
                finish();
            }
        };

        btnFacility.setOnClickListener(btnListener);
        btnHome.setOnClickListener(btnListener);
        btnSearch.setOnClickListener(btnListener);
        btnHome.setOnClickListener(btnListener);

        btnExtDong.setOnClickListener(floorListener);
        btnFloorB2.setOnClickListener(floorListener);
        btnFloorB1.setOnClickListener(floorListener);
        btnFloor1.setOnClickListener(floorListener);
        btnFloor2.setOnClickListener(floorListener);
        btnFloor3.setOnClickListener(floorListener);
        btnFloor4.setOnClickListener(floorListener);
        btnFloor5.setOnClickListener(floorListener);
        btnFloor6.setOnClickListener(floorListener);

        Typeface typefaceFloorBtn = Typeface.createFromAsset(getAssets(), "fonts/BaeminDH.otf");
        btnFloorB2.setTypeface(typefaceFloorBtn);
        btnFloorB1.setTypeface(typefaceFloorBtn);
        btnFloor1.setTypeface(typefaceFloorBtn);
        btnFloor2.setTypeface(typefaceFloorBtn);
        btnFloor3.setTypeface(typefaceFloorBtn);
        btnFloor4.setTypeface(typefaceFloorBtn);
        btnFloor5.setTypeface(typefaceFloorBtn);
        btnFloor6.setTypeface(typefaceFloorBtn);

        btnExtDong.setTypeface(typefaceBM);
        gaDong.setTypeface(typefaceBM);
        naDong.setTypeface(typefaceBM);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus){
        super.onWindowFocusChanged(hasFocus);
        if(hasFocus){
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }
}
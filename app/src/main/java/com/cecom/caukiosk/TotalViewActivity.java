package com.cecom.caukiosk;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Environment;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.File;

public class TotalViewActivity extends BaseActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        overridePendingTransition(0, 0);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_total_view);
        initialView();

        LinearLayout FB1Layout = findViewById(R.id.total_view_B1);
        LinearLayout FB2Layout = findViewById(R.id.total_view_B2);
        LinearLayout F1Layout = findViewById(R.id.total_view_1);
        LinearLayout F2Layout = findViewById(R.id.total_view_2);
        LinearLayout F3Layout = findViewById(R.id.total_view_3);
        LinearLayout F4Layout = findViewById(R.id.total_view_4);
        LinearLayout F5Layout = findViewById(R.id.total_view_5);
        LinearLayout F6Layout = findViewById(R.id.total_view_6);

        FB1Layout.setOnClickListener(floorListener);
        FB2Layout.setOnClickListener(floorListener);
        F1Layout.setOnClickListener(floorListener);
        F2Layout.setOnClickListener(floorListener);
        F3Layout.setOnClickListener(floorListener);
        F4Layout.setOnClickListener(floorListener);
        F5Layout.setOnClickListener(floorListener);
        F6Layout.setOnClickListener(floorListener);

        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator, "building_107.db");
        SQLiteDatabase sampleDB =  SQLiteDatabase.openOrCreateDatabase(file,  null);
        Cursor c = sampleDB.rawQuery("SELECT * FROM total_desc",null);

        if(c != null){
            if(c.moveToFirst()){
                while(c.moveToNext()){
                    LinearLayout.LayoutParams tvParam = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);
                    tvParam.setMargins(0, 0, 0, 13);

                    TextView tv = new TextView(this);
                    tv.setText(c.getString(c.getColumnIndex("name")));
                    tv.setLayoutParams(tvParam);
                    tv.setTextSize(25);
                    tv.setGravity(Gravity.CENTER);

                    String curFloor = c.getString(c.getColumnIndex("floor"));
                    if(curFloor.startsWith("B")) {
                        if(curFloor.equalsIgnoreCase("b1")){
                            FB1Layout.addView(tv);
                        }else{
                            FB2Layout.addView(tv);
                        }
                    }else{

                        switch(Integer.parseInt(curFloor)) {
                            case 1:
                                F1Layout.addView(tv);
                                break;
                            case 2:
                                F2Layout.addView(tv);
                                break;
                            case 3:
                                F3Layout.addView(tv);
                                break;
                            case 4:
                                F4Layout.addView(tv);
                                break;
                            case 5:
                                F5Layout.addView(tv);
                                break;
                            case 6:
                                F6Layout.addView(tv);
                                break;
                        }
                    }
                }
            }

            c.close();
        }

        sampleDB.close();
        setUpAdmin();
    }

    View.OnClickListener floorListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(getApplicationContext(), FloorActivity.class);
            switch(view.getId()){
                case R.id.total_view_B2:
                    intent.putExtra("Floor", "B2");
                    break;
                case R.id.total_view_B1:
                    intent.putExtra("Floor", "B1");
                    break;
                case R.id.total_view_1:
                    intent.putExtra("Floor", "1");
                    break;
                case R.id.total_view_2:
                    intent.putExtra("Floor", "2");
                    break;
                case R.id.total_view_3:
                    intent.putExtra("Floor", "3");
                    break;
                case R.id.total_view_4:
                    intent.putExtra("Floor", "4");
                    break;
                case R.id.total_view_5:
                    intent.putExtra("Floor", "5");
                    break;
                case R.id.total_view_6:
                    intent.putExtra("Floor", "6");
                    break;

            }
            startActivity(intent);
            finish();
        }
    };

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
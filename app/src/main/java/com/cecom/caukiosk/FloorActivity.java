package com.cecom.caukiosk;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.core.content.ContextCompat;

import com.cecom.caukiosk.buttons.*;

import java.io.File;

public class FloorActivity extends BaseActivity {
    String curFloor = "1";

    Button tempButton;
    FrameLayout btn_frameLayout;
    Typeface typefaceNG;
    Typeface typefaceSC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        overridePendingTransition(0, 0);
        super.onCreate(savedInstanceState);
        typefaceNG = Typeface.createFromAsset(getAssets(), "fonts/NanumBarunGothicR.otf");
        typefaceSC = Typeface.createFromAsset(getAssets(), "fonts/SCDreamEB.otf");
        Intent intent = getIntent();
        curFloor = intent.getStringExtra("Floor");
        LinearLayout[] categoryLayout = new LinearLayout[3];

        switch(curFloor){
            case "EXT":
                setContentView(R.layout.activity_floor_ext);
                FloorExtButton buttonExtClass = new FloorExtButton();
                buttonExtClass.initializeButton(this, getWindow().getDecorView());
                btn_frameLayout = findViewById(R.id.frameLayout_btn);
                categoryLayout[0] = findViewById(R.id.floor_1_layout_category);
                makeTextViewGroup();
                setCategory("ext",categoryLayout);
                break;
            case "B2":
                setContentView(R.layout.activity_floor_b2);
                FloorB2Button buttonB2Class = new FloorB2Button();
                buttonB2Class.initializeButton(this, getWindow().getDecorView());
                btn_frameLayout = findViewById(R.id.frameLayout_btn);
                categoryLayout[0] = findViewById(R.id.floor_1_layout_category);
                makeTextViewGroup();
                setCategory("b2",categoryLayout);
                start_line();
                break;
            case "B1":
                setContentView(R.layout.activity_floor_b1);
                FloorB1Button buttonB1Class = new FloorB1Button();
                buttonB1Class.initializeButton(this, getWindow().getDecorView());
                btn_frameLayout = findViewById(R.id.frameLayout_btn);
                categoryLayout[0] = findViewById(R.id.floor_1_layout_category);
                setCategory("b1",categoryLayout);
                makeTextViewGroup();
                start_line();
                break;
            case "1":
                setContentView(R.layout.activity_floor_1);
                Floor1Button button1Class = new Floor1Button();
                button1Class.initializeButton(this, getWindow().getDecorView());
                btn_frameLayout = findViewById(R.id.frameLayout_btn);
                categoryLayout[0] = findViewById(R.id.floor_1_layout_category);
                categoryLayout[1] = findViewById(R.id.floor_2_layout_category);
                categoryLayout[2] = findViewById(R.id.floor_3_layout_category);
                setCategory("1",categoryLayout);
                makeTextViewGroup();
                break;
            case "2":
                setContentView(R.layout.activity_floor_2);
                Floor2Button button2Class = new Floor2Button();
                button2Class.initializeButton(this, getWindow().getDecorView());
                btn_frameLayout = findViewById(R.id.frameLayout_btn);
                categoryLayout[0] = findViewById(R.id.floor_1_layout_category);
                categoryLayout[1] = findViewById(R.id.floor_2_layout_category);
                categoryLayout[2] = findViewById(R.id.floor_3_layout_category);
                setCategory("2",categoryLayout);
                makeTextViewGroup();
                break;
            case "3":
                setContentView(R.layout.activity_floor_3);
                Floor3Button button3Class = new Floor3Button();
                button3Class.initializeButton(this, getWindow().getDecorView());
                btn_frameLayout = findViewById(R.id.frameLayout_btn);
                categoryLayout[0] = findViewById(R.id.floor_1_layout_category);
                categoryLayout[1] = findViewById(R.id.floor_2_layout_category);
                categoryLayout[2] = findViewById(R.id.floor_3_layout_category);
                setCategory("3",categoryLayout);
                makeTextViewGroup();
                break;
            case "4":
                Log.d("floor","4");
                setContentView(R.layout.activity_floor_4);
                Floor4Button button4Class = new Floor4Button();
                button4Class.initializeButton(this, getWindow().getDecorView());
                btn_frameLayout = findViewById(R.id.frameLayout_btn);
                categoryLayout[0] = findViewById(R.id.floor_1_layout_category);
                categoryLayout[1] = findViewById(R.id.floor_2_layout_category);
                categoryLayout[2] = findViewById(R.id.floor_3_layout_category);
                setCategory("4",categoryLayout);
                makeTextViewGroup();
                break;

            case "5":
                setContentView(R.layout.activity_floor_5);
                Floor5Button button5Class = new Floor5Button();
                button5Class.initializeButton(this, getWindow().getDecorView());
                btn_frameLayout = findViewById(R.id.frameLayout_btn);
                categoryLayout[0] = findViewById(R.id.floor_1_layout_category);
                categoryLayout[1] = findViewById(R.id.floor_2_layout_category);
                categoryLayout[2] = findViewById(R.id.floor_3_layout_category);
                setCategory("5",categoryLayout);
                makeTextViewGroup();
                break;

            case "6":
                setContentView(R.layout.activity_floor_6);
                Floor6Button button6Class = new Floor6Button();
                button6Class.initializeButton(this, getWindow().getDecorView());
                btn_frameLayout = findViewById(R.id.frameLayout_btn);
                categoryLayout[0] = findViewById(R.id.floor_1_layout_category);
                categoryLayout[1] = findViewById(R.id.floor_2_layout_category);
                categoryLayout[2] = findViewById(R.id.floor_3_layout_category);
                setCategory("6",categoryLayout);
                makeTextViewGroup();
                break;
        }
        initialView();
        setUpAdmin();
    }

    private void start_line() {
        final ImageView[] myView = new ImageView[21];
        myView[0] = findViewById(R.id.line0);
        myView[1] = findViewById(R.id.line0_1);
        myView[2] = findViewById(R.id.line1);
        myView[3] = findViewById(R.id.line2);
        myView[4] = findViewById(R.id.line3);
        myView[5] = findViewById(R.id.line4);
        myView[6] = findViewById(R.id.line5);
        myView[7] = findViewById(R.id.line6);
        myView[8] = findViewById(R.id.line7);
        myView[9] = findViewById(R.id.line8);
        myView[10] = findViewById(R.id.line9);
        myView[11] = findViewById(R.id.line9_1);
        myView[12] = findViewById(R.id.line10);
        myView[13] = findViewById(R.id.line11);
        myView[14] = findViewById(R.id.line12);
        myView[15] = findViewById(R.id.line12_1);
        myView[16] = findViewById(R.id.line13);
        myView[17] = findViewById(R.id.line14);
        myView[18] = findViewById(R.id.line15);
        myView[19] = findViewById(R.id.line16);
        myView[20] = findViewById(R.id.line17);

        Handler mHandler = new Handler();
        for(int i = 0; i < 21; i++){
            final int finalI = i;
            mHandler.postDelayed(new Runnable()  {
                public void run() {
                   myView[finalI].setVisibility(View.VISIBLE);
                }
            }, (100 + 100 * (i + 1)));

        }
        mHandler.postDelayed(new Runnable()  {
            public void run() {
                for(int i = 0; i < 21; i++)
                myView[i].setVisibility(View.GONE);
            }
        }, (400 + 100 * (22 + 1)));
        mHandler.postDelayed(new Runnable()  {
            public void run() {
                for(int i = 0; i < 21; i++)
                    myView[i].setVisibility(View.VISIBLE);
            }
        }, (700 + 100 * (22 + 1)));
        mHandler.postDelayed(new Runnable()  {
            public void run() {
                for(int i = 0; i < 21; i++)
                    myView[i].setVisibility(View.GONE);
            }
        }, (1000 + 100 * (22 + 1)));
        mHandler.postDelayed(new Runnable()  {
            public void run() {
                for(int i = 0; i < 21; i++)
                    myView[i].setVisibility(View.VISIBLE);
            }
        }, (1200 + 100 * (22 + 1)));
    }

    private void setCategory(String floor, LinearLayout[] categoryLayout) {
        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator, "building_107.db");
        CategoryArrayList<Category> cateList = new CategoryArrayList<>();
        SQLiteDatabase sampleDB =  SQLiteDatabase.openOrCreateDatabase(file,  null);
        Cursor c = sampleDB.rawQuery("SELECT * FROM total_desc",null);
        if (c != null) {
            if (c.moveToFirst()) {
                do {
                    Log.d("asd",c.getString(c.getColumnIndex("floor")));
                    if(c.getString(c.getColumnIndex("floor")).toLowerCase().equals(floor)){
                        String cate = c.getString(c.getColumnIndex("name"));
                        Log.d("asb",cate);
                        if(!cate.equals("")){
                            int index = cateList.contains(cate);
                            if(index != -1){
                                String temp = cateList.get(index).room;
                                temp += ",";
                                if(temp.split(",").length %4 == 0){
                                    temp+="\n";
                                }
                                temp += c.getString(c.getColumnIndex("id"));
                                cateList.get(index).room = temp;
                            }
                            else{
                                cateList.add(new Category(cate+" | "+c.getString(c.getColumnIndex("categ")),c.getString(c.getColumnIndex("id"))));
                            }
                        }
                    }
                } while (c.moveToNext());
            }

            c.close();
        }

        for(int i = 0; i < cateList.size(); i++){
            final CategoryTextView tempView = new CategoryTextView(getApplicationContext(), cateList.get(i).room, cateList.get(i).cate);
            LinearLayout.LayoutParams tempViewParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1);
            tempViewParams.setMargins(-165,0,0,0);
            tempView.setLayoutParams(tempViewParams);
            tempView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String roomNum = tempView.tvNumber.getText().toString();
                    Log.d("test",roomNum);

                    ImageView mapImage = findViewById(R.id.floor_map);

                    boolean isEXT = true;
                    int mapHeight = mapImage.getHeight();
                    int mapWidth = mapImage.getWidth();
                    int mapMarginLeft = mapImage.getLeft();
                    int mapMarginTop = mapImage.getTop();
                    FrameLayout tempLayout = findViewById(R.id.frameLayout_btn);
                    for(int i = 0; i < tempLayout.getChildCount(); i++){
                        Button selButton = (Button) tempLayout.getChildAt(i);
                        Log.d("btn",selButton.getText().toString());
                        if(selButton.getText().toString().toLowerCase().trim().equals(roomNum.toLowerCase().trim())){
                            Log.d("input",roomNum);
                            isEXT = false;
                            openRoomInfo(roomNum, mapWidth, mapHeight, mapMarginLeft, mapMarginTop, selButton.getWidth(), selButton.getHeight(), selButton.getLeft(), selButton.getTop(), selButton.getRotation());
                            break;
                        }
                    }

                    if(isEXT){
                        openRoomInfo(roomNum, 0, 0, 0, 0, 0, 0, 0, 0, 0);
                    }
                }
            });
            if(floor.equals("b1") || floor.equals("b2") || floor.equals("ext")){
                categoryLayout[0].addView(tempView);
            }
            else{
                switch((i*3/(cateList.size()))){
                    case 0:
                        Log.d("fuc","0");
                        Log.d("test_sie",String.valueOf(i));
                        categoryLayout[0].addView(tempView);
                        break;
                    case 1:
                        Log.d("fuc","1");
                        categoryLayout[1].addView(tempView);
                        break;
                    case 2:
                        Log.d("fuc","2");
                        categoryLayout[2].addView(tempView);
                        break;
                }

            }
        }
        updateFloorButton(floor);
        sampleDB.close();
    }

    public void openRoomInfo(String selRoom, int width, int height, int marginLeft, int marginTop, int btnWidth, int btnHeight, int btnMarginLeft, int btnMarginTop, float btnRotation){
        Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
        intent.putExtra("NUM", selRoom);
        intent.putExtra("width", width);
        intent.putExtra("height", height);
        intent.putExtra("marginLeft", marginLeft);
        intent.putExtra("marginTop", marginTop);
        intent.putExtra("btnWidth", btnWidth);
        intent.putExtra("btnHeight", btnHeight);
        intent.putExtra("btnMarginLeft", btnMarginLeft);
        intent.putExtra("btnMarginTop", btnMarginTop);
        intent.putExtra("btnRotation", btnRotation);
        startActivity(intent);
        finish();
    }

    void makeTextViewGroup(){
        for(int i = 0; i < btn_frameLayout.getChildCount(); i++){
            tempButton = (Button) btn_frameLayout.getChildAt(i);
            tempButton.setTextSize(0);
            tempButton.setBackgroundColor(Color.parseColor("#00ff0000"));

        }
    }

    void updateFloorButton(String floor){
        Button btnFloor = findViewById(R.id.main_btn_floor_1);
        Button btnFloorDong = findViewById(R.id.main_btn_ga_dong);
        if(floor.toLowerCase().startsWith("b")){
            switch(floor.substring(1, 2)){
                case "1":
                    Log.d("input_b","b");
                    if(floor.charAt(1) == '1'){
                        Log.d("input_b1","b1");
                        btnFloor = findViewById(R.id.main_btn_floor_b1);
                        btnFloorDong = findViewById(R.id.main_btn_na_dong);
                    }
                    break;
                case "2":
                    Log.d("input_b","b");
                    if(floor.charAt(1) == '2'){
                        Log.d("input_b2","b2");
                        btnFloor = findViewById(R.id.main_btn_floor_b2);
                        btnFloorDong = findViewById(R.id.main_btn_na_dong);
                    }
                    break;
            }
        }else if(floor.equals("ext")){
            btnFloor = null;
            btnFloorDong = findViewById(R.id.main_btn_etc_dong);

            File imgFile = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "club_image" + File.separator, "ExternalClubMap.png");
            if(imgFile.exists()){
                Bitmap bm = BitmapFactory.decodeFile(imgFile.getPath());

                ImageView floorMapView = findViewById(R.id.floor_map);
                floorMapView.setImageBitmap(bm);
            }
        }else{
            Log.d("floor_number",floor);
            switch(floor.substring(0, 1).toLowerCase()) {
                case "1":
                    btnFloor = findViewById(R.id.main_btn_floor_1);
                    btnFloorDong = findViewById(R.id.main_btn_ga_dong);
                    break;
                case "2":
                    btnFloor = findViewById(R.id.main_btn_floor_2);
                    btnFloorDong = findViewById(R.id.main_btn_ga_dong);
                    break;
                case "3":
                    btnFloor = findViewById(R.id.main_btn_floor_3);
                    btnFloorDong = findViewById(R.id.main_btn_ga_dong);
                    break;
                case "4":
                    btnFloor = findViewById(R.id.main_btn_floor_4);
                    btnFloorDong = findViewById(R.id.main_btn_ga_dong);
                    break;
                case "5":
                    btnFloor = findViewById(R.id.main_btn_floor_5);
                    btnFloorDong = findViewById(R.id.main_btn_ga_dong);
                    break;
                case "6":
                    btnFloor = findViewById(R.id.main_btn_floor_6);
                    btnFloorDong = findViewById(R.id.main_btn_ga_dong);
                    break;
            }

        }

        if(!floor.equals("ext")){
            btnFloor.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.btn_main_floor_pressed));
        }

        btnFloorDong.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.btn_main_floor_pressed));
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
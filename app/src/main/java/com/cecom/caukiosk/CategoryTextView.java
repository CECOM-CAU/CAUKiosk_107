package com.cecom.caukiosk;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

@SuppressLint("ViewConstructor")
public class CategoryTextView extends LinearLayout{
    TextView tvNumber;
    TextView tvTitle;

    public CategoryTextView(Context context, String number, String title) {
        super(context);
        initView(number, title);
    }



    private void initView(String number, String title){
        LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        Typeface typefaceBM = Typeface.createFromAsset(getContext().getAssets(), "fonts/BaeminDH.otf");
        Typeface typefaceNG = Typeface.createFromAsset(getContext().getAssets(), "fonts/NanumSquareL.otf");
        View view = inflater.inflate(R.layout.tv_category, this, false);
        addView(view);

        tvNumber = findViewById(R.id.tv_category_num);
        tvTitle = findViewById(R.id.tv_category_title);

        tvNumber.setTypeface(typefaceNG);
        tvTitle.setTypeface(typefaceBM);

        tvTitle.setTextSize(12);

        tvNumber.setText(number);
        tvTitle.setText(title);
    }
}

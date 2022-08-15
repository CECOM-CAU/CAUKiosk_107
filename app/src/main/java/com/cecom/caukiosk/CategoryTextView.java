package com.cecom.caukiosk;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CategoryTextView extends LinearLayout{
    TextView tvNumber;
    TextView tvTitle;

    public CategoryTextView(Context context, String number, String title) {
        super(context);
        initView(number, title);
    }

    public CategoryTextView(Context context, AttributeSet attrs, String number, String title) {
        super(context, attrs);
        initView(number, title);
        getAttrs(attrs);
    }

    public CategoryTextView(Context context, AttributeSet attrs, int defStyle, String number, String title) {
        super(context, attrs);
        initView(number, title);
        getAttrs(attrs, defStyle);
    }

    private void getAttrs(AttributeSet attrs) {
        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.CategoryTextView);
        setTypeArray(typedArray);
    }


    private void getAttrs(AttributeSet attrs, int defStyle) {
        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.CategoryTextView, defStyle, 0);
        setTypeArray(typedArray);
    }


    private void setTypeArray(TypedArray typedArray) {
        String strNumber = typedArray.getString(R.styleable.CategoryTextView_number);
        tvNumber.setText(strNumber);

        String strTitle = typedArray.getString(R.styleable.CategoryTextView_title);
        tvTitle.setText(strTitle);

        typedArray.recycle();

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

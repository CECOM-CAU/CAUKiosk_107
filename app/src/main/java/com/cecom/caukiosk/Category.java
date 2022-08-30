package com.cecom.caukiosk;

import androidx.annotation.NonNull;

public class Category {
    String cate;
    String room;

    Category(String cate, String room){
        this.cate = cate;
        this.room = room;
    }

    @NonNull
    @Override
    public String toString() {
        return this.cate;
    }
}

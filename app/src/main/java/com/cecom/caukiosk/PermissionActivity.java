package com.cecom.caukiosk;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;


public class PermissionActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permission);
        activateKIOSK(true);
        Intent mainIntent = new Intent(PermissionActivity.this, MainActivity.class);
        startActivity(mainIntent);
        finish();

    }
    private void activateKIOSK(boolean status){
        LockUtil.lock(PermissionActivity.this);
        startLockTask();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(KioskModeApp.isInLockMode == true){
            ActivityManager activityManager = (ActivityManager) getApplicationContext()
                    .getSystemService(Context.ACTIVITY_SERVICE);
            activityManager.moveTaskToFront(getTaskId(), 0);
        }
    }

}
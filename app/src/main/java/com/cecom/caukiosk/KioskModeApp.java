package com.cecom.caukiosk;

import android.app.Application;

/**
 * Created by derohimat on 19/08/2016.
 */
public class KioskModeApp extends Application {

    public static boolean isInLockMode = true;

    public static void setIsInLockMode(boolean isInLockMode) {
        KioskModeApp.isInLockMode = isInLockMode;
    }
}

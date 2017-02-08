package com.example.gsu.pawardemo;

import android.app.Application;

import com.example.gsu.pawardemo.util.UtilLog;

/**
 * Created by GSU on 2/6/17.
 */

public class PawarApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        UtilLog.setDebug(true);
    }
}

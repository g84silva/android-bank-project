package com.example.bankproject.View;

import android.app.Application;

import com.facebook.stetho.Stetho;

public class ViewUsersBank extends Application {

    private static ViewUsersBank instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        Stetho.initializeWithDefaults(this);
    }

    public static ViewUsersBank getInstance() {
        return instance;
    }

}

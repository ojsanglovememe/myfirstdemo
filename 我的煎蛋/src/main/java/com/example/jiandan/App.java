package com.example.jiandan;

import android.app.Application;

import org.xutils.x;

/**
 * Created by Administrator on 2016/2/24.
 */
public class App extends Application {
    @Override
    public void onCreate() {
        x.Ext.init(this);
        super.onCreate();
    }
}

package com.users.xucanyou666.rxjava2_retrofit_mvp.base;


import android.app.Application;
import android.content.Context;

/**
 * 基类
 * created by xucanyou666
 * on 2019/11/2 14:46
 * email：913710642@qq.com
 * @author xucanyou666
 */
public class MyApplication extends Application {
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public static Context getContext() {
        return context;
    }
}

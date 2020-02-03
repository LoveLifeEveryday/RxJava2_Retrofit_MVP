package com.users.xucanyou666.rxjava2_retrofit_mvp.util;


import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.users.xucanyou666.rxjava2_retrofit_mvp.contants.StaticQuality.BASE_URL;

/**
 * Retrofit单例工具类
 * created by xucanyou666
 * on 2020/1/16 16:38
 * email：913710642@qq.com
 */
public class RetrofitManager {
    private Retrofit mRetrofit;


    //构造器私有，这个工具类只有一个实例
    private RetrofitManager() {
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
        httpClientBuilder.connectTimeout(15, TimeUnit.SECONDS);
        mRetrofit = new Retrofit.Builder()
                .client(httpClientBuilder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(BASE_URL)
                .build();
    }


    /**
     * 静态内部类单例模式
     *
     * @return
     */
    public static RetrofitManager getInstance() {
        return Inner.retrofitManager;
    }

    private static class Inner {
        private static final RetrofitManager retrofitManager = new RetrofitManager();
    }


    /**
     * 利用泛型传入接口class返回接口实例
     *
     * @param ser 类
     * @param <T> 类的类型
     * @return Observable
     */
    public <T> T createRs(Class<T> ser) {
        return mRetrofit.create(ser);
    }
}

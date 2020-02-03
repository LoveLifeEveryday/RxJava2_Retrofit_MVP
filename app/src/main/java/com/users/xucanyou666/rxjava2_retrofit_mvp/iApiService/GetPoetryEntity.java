package com.users.xucanyou666.rxjava2_retrofit_mvp.iApiService;


import com.users.xucanyou666.rxjava2_retrofit_mvp.entity.PoetryEntity;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * retrofit接口
 * created by xucanyou666
 * on 2020/1/23 21:25
 * email：913710642@qq.com
 */
public interface GetPoetryEntity {
    /**
     * 获取古诗词
     *
     * @return 古诗词
     */
    @GET("all.json")
    Observable<PoetryEntity> getPoetry();
}

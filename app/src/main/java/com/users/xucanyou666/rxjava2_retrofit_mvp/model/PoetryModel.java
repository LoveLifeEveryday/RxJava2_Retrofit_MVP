package com.users.xucanyou666.rxjava2_retrofit_mvp.model;


import com.users.xucanyou666.rxjava2_retrofit_mvp.contract.IPoetryContract;
import com.users.xucanyou666.rxjava2_retrofit_mvp.entity.PoetryEntity;
import com.users.xucanyou666.rxjava2_retrofit_mvp.iApiService.GetPoetryEntity;
import com.users.xucanyou666.rxjava2_retrofit_mvp.util.RetrofitManager;

import io.reactivex.Observable;

/**
 * created by xucanyou666
 * on 2020/1/16 17:06
 * email：913710642@qq.com
 */
public class PoetryModel implements IPoetryContract.IPoetryModel {


    private PoetryModel() {

    }

    public static PoetryModel getInstance() {
        return Inner.instance;
    }

    private static class Inner {
        private static final PoetryModel instance = new PoetryModel();
    }


    /**
     * 获取古诗词
     *
     * @return 古诗词
     */
    @Override
    public Observable<PoetryEntity> getPoetry() {
        return RetrofitManager.getInstance().createRs(GetPoetryEntity.class).getPoetry();
    }


}

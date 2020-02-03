package com.users.xucanyou666.rxjava2_retrofit_mvp.contract;


import com.users.xucanyou666.rxjava2_retrofit_mvp.base.BaseView;
import com.users.xucanyou666.rxjava2_retrofit_mvp.entity.PoetryEntity;

import io.reactivex.Observable;

/**
 * 诗歌的接口管理器
 * created by xucanyou666
 * on 2020/2/2 15:33
 * email：913710642@qq.com
 */
public interface IPoetryContract {
    interface IPoetryModel {
        /**
         * 得到诗歌
         *
         * @return 诗歌
         */
        Observable<PoetryEntity> getPoetry();
    }

    interface IPoetryPresenter {
        void getPoetry();
    }

    interface IPoetryView extends BaseView {
        /**
         * @param author 作者
         */
        void searchSuccess(String author);
    }
}

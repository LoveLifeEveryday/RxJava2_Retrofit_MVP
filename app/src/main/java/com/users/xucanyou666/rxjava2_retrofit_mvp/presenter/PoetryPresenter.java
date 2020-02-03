package com.users.xucanyou666.rxjava2_retrofit_mvp.presenter;


import android.util.Log;

import com.users.xucanyou666.rxjava2_retrofit_mvp.base.BasePresenter;
import com.users.xucanyou666.rxjava2_retrofit_mvp.contract.IPoetryContract;
import com.users.xucanyou666.rxjava2_retrofit_mvp.entity.PoetryEntity;
import com.users.xucanyou666.rxjava2_retrofit_mvp.model.PoetryModel;
import com.users.xucanyou666.rxjava2_retrofit_mvp.util.RxJavaUtil;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * created by xucanyou666
 * on 2020/1/16 17:09
 * email：913710642@qq.com
 */
public class PoetryPresenter extends BasePresenter<IPoetryContract.IPoetryView> implements IPoetryContract.IPoetryPresenter {

    private static final String TAG = "PoetryPresenter";

    private PoetryEntity mPoetryEntity;
    private PoetryModel mPoetryModel;

    private PoetryPresenter() {
        mPoetryModel = PoetryModel.getInstance();
    }

    public static PoetryPresenter getInstance() {
        return Inner.instance;
    }

    private static class Inner {
        private static final PoetryPresenter instance = new PoetryPresenter();
    }

    /**
     * 得到诗歌
     */
    @Override
    public void getPoetry() {
        Observable observable = mPoetryModel.getPoetry().doOnSubscribe(new Consumer<Disposable>() {
            @Override
            public void accept(Disposable disposable) throws Exception {
                addDisposable(disposable);
            }
        });
        observable = RxJavaUtil.toSubscribe(observable);
        observable.subscribe(new Observer<PoetryEntity>() {
            @Override
            public void onSubscribe(Disposable d) {
            }

            @Override
            public void onNext(PoetryEntity poetryEntity) {
                mPoetryEntity = poetryEntity;
            }

            @Override
            public void onError(Throwable e) {
                getMvpView().onError(e.getMessage());
                Log.d(TAG, "onError: " + e.getMessage());
            }

            @Override
            public void onComplete() {
                if (mPoetryEntity != null) {
                    getMvpView().searchSuccess(mPoetryEntity.getAuthor());
                }
            }
        });

    }
}


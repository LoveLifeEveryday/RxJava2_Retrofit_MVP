package com.users.xucanyou666.rxjava2_retrofit_mvp.util;


import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * created by xucanyou666
 * on 2019/11/17 19:20
 * email：913710642@qq.com
 *
 * @author xucanyou666
 */
public class RxJavaUtil {
    /**
     * 线程调度工作
     *
     * @param observable 被观察者
     * @param <T>        类型
     */
    public static <T> Observable  toSubscribe(Observable<T> observable) {
        return observable.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

}

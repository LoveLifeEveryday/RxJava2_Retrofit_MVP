package com.users.xucanyou666.rxjava2_retrofit_mvp.base;


/**
 * created by xucanyou666
 * on 2020/1/31 18:26
 * email：913710642@qq.com
 */
public interface BaseView {

    /**
     * 显示进度框
     */
    void showProgressDialog();


    /**
     * 关闭进度框
     */
    void hideProgressDialog();


    /**
     * 出错信息的回调
     *
     * @param result 错误信息
     */
    void onError(String result);



}

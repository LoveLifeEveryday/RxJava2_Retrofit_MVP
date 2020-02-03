package com.users.xucanyou666.rxjava2_retrofit_mvp.base;


/**
 * created by xucanyou666  MVP活动的基类，封装好了一些销毁presenter的解绑
 * on 2019/12/24 20:53
 * email：913710642@qq.com
 */

public abstract class BaseMvpActivity<V extends BaseView, P extends BasePresenter> extends BaseActivity {

    private P presenter;

    /**
     * 初始化presenter
     */
    @Override
    protected void initPresenter() {
        presenter = createPresenter();
        if (presenter != null) {
            presenter.attachView((V) this);
        }
    }

    /**
     * 创建presenter
     *
     * @return Presenter
     */
    protected abstract P createPresenter();


    /**
     * 得到presenter
     *
     * @return presenter
     */
    protected P getPresenter() {
        return presenter;
    }

    /**
     * 销毁
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.detachView();
        }
    }


}

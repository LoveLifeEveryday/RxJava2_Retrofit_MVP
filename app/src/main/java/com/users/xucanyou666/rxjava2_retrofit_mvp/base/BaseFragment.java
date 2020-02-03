package com.users.xucanyou666.rxjava2_retrofit_mvp.base;


import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import butterknife.ButterKnife;
import butterknife.Unbinder;

import static android.content.ContentValues.TAG;

/**
 * Fragment的基类，封装了一些Fragment的相关操作
 * created by xucanyou666
 * on 2020/1/31 16:21
 * email：913710642@qq.com
 */
public abstract class BaseFragment<T extends BasePresenter> extends Fragment implements BaseView {
    protected T mPresenter;
    protected Context mContext;
    protected Bundle mBundle;
    protected Unbinder unbinder;
    protected View view;

    /**
     * 恢复数据
     *
     * @param outState bundle
     */
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        if (mBundle != null) {
            outState.putBundle("bundle", mBundle);
        }
    }

    /**
     * 绑定activity
     *
     * @param context context
     */
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mContext = context;
    }

    /**
     * 运行在onAttach之后，可以接收别人传递过来的参数，实例化对象
     * 可以解决返回的时候页面空白的bug
     *
     * @param savedInstanceState
     */
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            mBundle = savedInstanceState.getBundle("bundle");
        } else {
            mBundle = getArguments() == null ? new Bundle() : getArguments();
        }
        //初始化presenter
        mPresenter = initPresenter();
    }

    protected T getPresenter() {
        return mPresenter;
    }


    /**
     * 运行在onCreate之后，生成View视图
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = initView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    /**
     * 运行在onCreateView之后
     * 加载数据
     *
     * @param savedInstanceState
     */
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mPresenter.attachView(this);

    }


    /**
     * 跳转Fragment
     *
     * @param toFragment 跳转去的fragment
     */
    public void startFragment(Fragment toFragment) {
        Log.d(TAG, "haha");
        startFragment(toFragment, null);
    }

    /**
     * 跳转Fragment
     *
     * @param toFragment 跳转到的fragment
     * @param tag        fragment的标签
     */
    public void startFragment(Fragment toFragment, String tag) {
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.hide(this).add(android.R.id.content, toFragment, tag);
        fragmentTransaction.addToBackStack(tag);
        fragmentTransaction.commitAllowingStateLoss();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    /**
     * fragment进行回退
     * 类似于activity的OnBackPress
     */
    public void onBack() {
        getFragmentManager().popBackStack();
    }

    @Override
    public void onDetach() {
        mPresenter.detachView();
        super.onDetach();
    }

    /**
     * 初始化Fragment应有的视图
     *
     * @return view
     */
    public abstract View initView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState);


    /**
     * 创建presenter
     *
     * @return <T extends BasePresenter> 必须是BasePresenter的子类
     */
    public abstract T initPresenter();

    /**
     * 得到context
     *
     * @return context
     */
    @Override
    public Context getContext() {
        return mContext;
    }

    /**
     * 得到bundle
     *
     * @return bundle
     */
    public Bundle getBundle() {
        return mBundle;
    }

    /**
     * 得到fragment
     *
     * @return fragment
     */
    public Fragment getFragment() {
        return this;
    }


}

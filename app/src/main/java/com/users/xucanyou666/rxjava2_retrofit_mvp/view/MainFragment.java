package com.users.xucanyou666.rxjava2_retrofit_mvp.view;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.users.xucanyou666.rxjava2_retrofit_mvp.R;
import com.users.xucanyou666.rxjava2_retrofit_mvp.base.BaseFragment;
import com.users.xucanyou666.rxjava2_retrofit_mvp.base.MyApplication;
import com.users.xucanyou666.rxjava2_retrofit_mvp.contract.IPoetryContract;
import com.users.xucanyou666.rxjava2_retrofit_mvp.presenter.PoetryPresenter;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Description : MainFragment
 *
 * @author XuCanyou666
 * @date 2020/2/2
 */


public class MainFragment extends BaseFragment<PoetryPresenter> implements IPoetryContract.IPoetryView {


    @BindView(R.id.btn_get_poetry)
    Button btnGetPoetry;
    @BindView(R.id.tv_poetry_author)
    TextView tvPoetryAuthor;




    @Override
    public View initView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public PoetryPresenter initPresenter() {
        return PoetryPresenter.getInstance();
    }


    @Override
    public void showProgressDialog() {

    }

    @Override
    public void hideProgressDialog() {

    }

    @Override
    public void onError(String result) {
        Toast.makeText(MyApplication.getContext(), result, Toast.LENGTH_SHORT).show();

    }

    @OnClick(R.id.btn_get_poetry)
    public void onViewClicked() {
        getPresenter().getPoetry();
    }

    @Override
    public void searchSuccess(String author) {
        tvPoetryAuthor.setText(author);
    }
}

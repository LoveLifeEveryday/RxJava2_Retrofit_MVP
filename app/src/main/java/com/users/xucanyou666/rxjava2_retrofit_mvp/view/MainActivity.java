package com.users.xucanyou666.rxjava2_retrofit_mvp.view;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.FragmentTransaction;

import com.users.xucanyou666.rxjava2_retrofit_mvp.R;
import com.users.xucanyou666.rxjava2_retrofit_mvp.base.BaseMvpActivity;
import com.users.xucanyou666.rxjava2_retrofit_mvp.base.MyApplication;
import com.users.xucanyou666.rxjava2_retrofit_mvp.contract.IPoetryContract;
import com.users.xucanyou666.rxjava2_retrofit_mvp.presenter.PoetryPresenter;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Description : MainActivity
 *
 * @author XuCanyou666
 * @date 2020/2/3
 */

public class MainActivity extends BaseMvpActivity<MainActivity, PoetryPresenter> implements IPoetryContract.IPoetryView {

    @BindView(R.id.btn_get_poetry)
    Button btnGetPoetry;
    @BindView(R.id.tv_poetry_author)
    TextView tvPoetryAuthor;
    @BindView(R.id.btn_goto_fragment)
    Button btnGotoFragment;
    @BindView(R.id.ll)
    LinearLayout ll;

    @Override
    protected void initViews() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected PoetryPresenter createPresenter() {
        return PoetryPresenter.getInstance();
    }

    @Override
    public void searchSuccess(String author) {
        tvPoetryAuthor.setText(author);
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

    private static final String TAG = "MainActivity";

    @OnClick({R.id.btn_get_poetry, R.id.btn_goto_fragment})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_get_poetry:
                getPresenter().getPoetry();
                break;
            case R.id.btn_goto_fragment:
                startFragment(R.id.ll, new MainFragment());
                break;
            default:
                break;
        }
    }
}

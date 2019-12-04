package com.bawei.pss20191204.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.bawei.pss20191204.Contracts;

/**
 * Created by Android Studio.
 * User: 潘世松
 * Date: 2019/12/4
 * Time: 9:05
 */
public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements Contracts.IView {
    protected P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(layoutID());
        initView();
        initData();
        mPresenter = initPresenter();
        mPresenter.onAttchView(this);
        startCoding();
    }

    protected abstract void startCoding();

    protected abstract P initPresenter();

    protected abstract void initData();


    protected abstract void initView();

    protected abstract int layoutID();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.onDeAttchView();
            mPresenter = null;
        }
    }
}

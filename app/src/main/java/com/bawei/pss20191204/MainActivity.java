package com.bawei.pss20191204;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.bawei.pss20191204.adapter.MyAdapter;
import com.bawei.pss20191204.base.BaseActivity;
import com.bawei.pss20191204.base.BasePresenter;
import com.bawei.pss20191204.bean.DataBean;
import com.bawei.pss20191204.presenter.PresenterImpl;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    private RecyclerView recy_view;
    private String url = "http://blog.zhaoliang5156.cn/api/news/lawyer.json";
    private List<DataBean.ListdataBean> list = new ArrayList<>();
    private MyAdapter myAdapter;

    @Override
    protected void startCoding() {
        mPresenter.startRequest(url);
    }

    @Override
    protected BasePresenter initPresenter() {
        return new PresenterImpl();
    }

    @Override
    protected void initData() {
        myAdapter = new MyAdapter(this, list);
        recy_view.setAdapter(myAdapter);
    }

    @Override
    protected void initView() {
        recy_view = (RecyclerView) findViewById(R.id.recy_view);
        recy_view.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected int layoutID() {
        return R.layout.activity_main;
    }


    @Override
    public void onSuccess(String jsonStr) {
        DataBean dataBean = new Gson().fromJson(jsonStr, DataBean.class);
        list.clear();
        list.addAll(dataBean.getListdata());
        myAdapter.notifyDataSetChanged();
    }

    @Override
    public void onError(String error) {

    }
}

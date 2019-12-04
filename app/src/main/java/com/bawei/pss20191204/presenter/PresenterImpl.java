package com.bawei.pss20191204.presenter;

import com.bawei.pss20191204.Contracts;
import com.bawei.pss20191204.base.BasePresenter;
import com.bawei.pss20191204.model.ModelImpl;

/**
 * Created by Android Studio.
 * User: 潘世松
 * Date: 2019/12/4
 * Time: 9:07
 */
public class PresenterImpl extends BasePresenter {

    private ModelImpl model;

    @Override
    protected void initModel() {
        model = new ModelImpl();
    }

    @Override
    public void startRequest(String url) {
        model.onGetIofo(url, new Contracts.MyCallBack() {
            @Override
            public void onSuccess(String jsonStr) {
                getView().onSuccess(jsonStr);
            }

            @Override
            public void onError(String error) {
                getView().onError(error);
            }
        });
    }
}

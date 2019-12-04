package com.bawei.pss20191204.model;

import com.bawei.pss20191204.Contracts;
import com.bawei.pss20191204.utils.NetUtil;

/**
 * Created by Android Studio.
 * User: 潘世松
 * Date: 2019/12/4
 * Time: 9:06
 */
public class ModelImpl implements Contracts.IModel {
    @Override
    public void onGetIofo(String url, final Contracts.MyCallBack myCallBack) {
        NetUtil.getInstance().asyncGet(url, new NetUtil.NetCallBack() {
            @Override
            public void onSuccess(String json) {
                myCallBack.onSuccess(json);
            }

            @Override
            public void onError(String error) {
                myCallBack.onError(error);
            }
        });
    }
}

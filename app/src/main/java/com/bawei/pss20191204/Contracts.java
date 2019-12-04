package com.bawei.pss20191204;

/**
 * Created by Android Studio.
 * User: 潘世松
 * Date: 2019/12/4
 * Time: 9:02
 */
public interface Contracts {

    interface IModel{
        void onGetIofo(String url,MyCallBack myCallBack);
    }

    interface IView{
        void onSuccess(String jsonStr);
        void onError(String error);
    }

    interface IPresenter{
        void startRequest(String url);
    }

    interface MyCallBack{
        void onSuccess(String jsonStr);
        void onError(String error);
    }
}

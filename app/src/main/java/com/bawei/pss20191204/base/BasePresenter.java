package com.bawei.pss20191204.base;

import com.bawei.pss20191204.Contracts;

import java.lang.ref.WeakReference;

/**
 * Created by Android Studio.
 * User: 潘世松
 * Date: 2019/12/4
 * Time: 9:03
 */
public abstract class BasePresenter<V extends Contracts.IView> implements Contracts.IPresenter {
    private WeakReference<V> mWeakR;
    public BasePresenter(){
        initModel();
    }


    protected abstract void initModel();

    protected void onAttchView(V v){
        mWeakR = new WeakReference<>(v);
    }
    protected void onDeAttchView(){
        if (mWeakR != null) {
            mWeakR.clear();
            mWeakR = null;
        }
    }
    protected V getView(){
        return mWeakR.get();
    }


}

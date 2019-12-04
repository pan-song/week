package com.bawei.pss20191204.app;

import android.app.Application;

import com.bawei.pss20191204.dao.DaoMaster;
import com.bawei.pss20191204.dao.DaoSession;

/**
 * Created by Android Studio.
 * User: 潘世松
 * Date: 2019/12/4
 * Time: 8:51
 */
public class MyApplication extends Application {
    private DaoSession mDaoSession;

    @Override
    public void onCreate() {
        super.onCreate();

        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(this, "pss.db");
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDatabase());
        mDaoSession = daoMaster.newSession();
    }

    public DaoSession getmDaoSession() {
        return mDaoSession;
    }

}

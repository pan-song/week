package com.bawei.pss20191204.utils;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by Android Studio.
 * User: 潘世松
 * Date: 2019/12/4
 * Time: 8:55
 */
public class NetUtil {

    private HttpLoggingInterceptor interceptor;
    private OkHttpClient mOkHttpClient;
    private NetCallBack mNetCallBack;

    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    mNetCallBack.onSuccess(msg.obj.toString());
                    break;
                case 2:
                    mNetCallBack.onError(msg.obj.toString());
                    break;
            }
        }
    };

    private NetUtil() {
        interceptor = new HttpLoggingInterceptor();
        mOkHttpClient = new OkHttpClient.Builder().addInterceptor(interceptor)
                .build();
    }

    private static class NetHolder {
        private static NetUtil netUtil = new NetUtil();
    }

    public static NetUtil getInstance() {
        return NetHolder.netUtil;
    }

    public void asyncGet(String url, NetCallBack netCallBack) {
        mNetCallBack = netCallBack;
        Request request = new Request.Builder().url(url).build();
        mOkHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                handler.sendMessage(handler.obtainMessage(2, e.getMessage()));
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                handler.sendMessage(handler.obtainMessage(1, response.body().string()));
            }
        });
    }


    public interface NetCallBack {
        void onSuccess(String json);

        void onError(String error);
    }
}

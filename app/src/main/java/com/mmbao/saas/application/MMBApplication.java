package com.mmbao.saas.application;

import android.app.Application;
import android.content.Context;

import com.mmbao.saas.constant.ApplicationGlobal;
import com.mmbao.saas.net.ApiService;
import com.mmbao.saas.net.Cookies;
import com.mmbao.saas.net.SystemInfo;
import com.mmbao.saas.util.DeviceUuidFactory;

import java.io.File;
import java.io.IOException;

import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Description:com.mmbao.saas.application类
 * Created by Administrator on 2018/1/27.
 * Maxim:There is no smoke without fire
 */

public class MMBApplication extends Application {

    private static Context context;
    public static ApiService service;
    private static MMBApplication instance;
    public String imei;//设备号


    public static MMBApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        context = getApplicationContext();
        instance = this;
        imei = DeviceUuidFactory.getUUID(getApplicationContext());
    }

}

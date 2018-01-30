package com.mmbao.saas.controller;

import android.content.Context;

import com.mmbao.saas.bean.LoginBean;

/**
 * Description:com.mmbao.saas.model类
 * Created by Administrator on 2018/1/28.
 * Maxim:There is no smoke without fire
 */

public class LoginContract {

    public interface LoginView{

        //检查账号密码格式
        void onCheckFormatSuccess();

        void onCheckFormatFail(String info);

        //登录
        void onLoginSuccess(LoginBean login);

        void onLoginFail(String errorInfo);
    }

    public interface LoginModel {

        void login(Context context, String name, String password, CallBack<LoginBean> callBack);

    }
}

package com.mmbao.saas.model;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.mmbao.saas.base.BaseModelImpl;
import com.mmbao.saas.bean.LoginBean;
import com.mmbao.saas.constant.Constants;
import com.mmbao.saas.controller.CallBack;
import com.mmbao.saas.controller.LoginContract;
import com.mmbao.saas.net.ApiService;
import com.mmbao.saas.net.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 实现登录接口调用
 * Description:com.mmbao.saas.model类
 * Created by Administrator on 2018/1/22.
 * Maxim:There is no smoke without fire
 */
public class LoginModelImpl extends BaseModelImpl<LoginContract.LoginView> {

    private LoginModelImpl model;
    private Context context;
    private CallBack<LoginBean> callBack;

    public LoginModelImpl(){
        model = new LoginModelImpl();
    }
//    public LoginModelImpl(Context context){
//        this.context = context;
//        model = new LoginModelImpl(context);
//    }

    /**
     * 检查格式
     * @param name
     * @param password
     */
    public void checkFormat(String name,String password){
        if (TextUtils.isEmpty(name)){
            getView().onCheckFormatFail("请输入用户名/手机号");
        }else if (TextUtils.isEmpty(password)){
            getView().onCheckFormatFail("请输入密码");
        }else if (password.length()<6 || password.length()>18){
            getView().onCheckFormatFail("密码格式不正确");
        }else {
            getView().onCheckFormatSuccess();
            login(context,name,password,callBack);
        }
    }

    private void login(Context context, String name, String password, final CallBack<LoginBean> callBack) {
        //网络层

        Call<JsonObject> call = RetrofitClient.getInstance(context).create(ApiService.class).login(name,password,"","","");
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(@NonNull Call<JsonObject> call, @NonNull Response<JsonObject> response) {
                if (response.isSuccessful()){
                    JsonObject object = response.body();
                    if (null!=object){
                        LoginBean bean = new Gson().fromJson(object,LoginBean.class);
                        String result = bean.getCode();
                        if (Constants.SUCCESS_RESPONSE.equals(result)){
                            callBack.onResponse(bean);
                        }else {
                            callBack.onFailure("");
                        }
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<JsonObject> call, @NonNull Throwable t) {
                callBack.onFailure("");
            }
        });
    }
}

package com.mmbao.saas.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.mmbao.saas.R;
import com.mmbao.saas.base.BaseActivity;
import com.mmbao.saas.bean.LoginBean;
import com.mmbao.saas.controller.LoginContract;
import com.mmbao.saas.model.LoginModelImpl;

public class LoginActivity extends BaseActivity<LoginContract.LoginView,LoginModelImpl> implements LoginContract.LoginView,View.OnClickListener{


    //-------------------------- view层----------------------
    @Override
    protected void onCreateActivity(Bundle savedInstanceState) {
        setContentView(R.layout.activity_login);
    }

    @Override
    protected LoginModelImpl createModelImpl() {
        return new LoginModelImpl();
    }

    //-------------------------- model层----------------------
    @Override
    public void onCheckFormatSuccess() {

    }

    @Override
    public void onCheckFormatFail(String info) {  //格式错误，弹出相应提示语
        showShortToast(info);
    }

    @Override
    public void onLoginSuccess(LoginBean login) {

    }

    @Override
    public void onLoginFail(String errorInfo) {
        showShortToast(errorInfo);
    }

    //-------------------------- 点击事件----------------------
    @Override
    public void onClick(View view) {

    }
}

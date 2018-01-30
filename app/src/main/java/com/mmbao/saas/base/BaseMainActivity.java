package com.mmbao.saas.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import butterknife.ButterKnife;

/**
 * Description:com.mmbao.saas.base类
 * Created by Administrator on 2018/1/28.
 * Maxim:There is no smoke without fire
 */

public abstract class BaseMainActivity extends AppCompatActivity {
    private static final String TAG = "BaseActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView();
        ButterKnife.bind(this);

        init();
    }

    //设置布局
    public abstract void setContentView();

    //初始化控件
    protected abstract void init();

    public void showToast(String msg) {
        Toast.makeText(BaseMainActivity.this, msg, Toast.LENGTH_SHORT).show();
    }
}

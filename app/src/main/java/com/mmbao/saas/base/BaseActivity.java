package com.mmbao.saas.base;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

import butterknife.ButterKnife;

/**
 * Description:com.mmbao.saas.base类
 * Created by Administrator on 2018/1/28.
 * Maxim:There is no smoke without fire
 */

@SuppressLint("Registered")
public abstract class BaseActivity<V,M extends BaseModelImpl> extends FragmentActivity{
    public String TAG = getClass().getSimpleName() + "";

    public Context mContext;
    protected M mModelImpl;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        onCreateActivity(savedInstanceState);
        ButterKnife.bind(this);
        mContext = BaseActivity.this;
        mModelImpl = createModelImpl();
    }

    /**
     * 实现Activity中的onCreate()方法
     * @param savedInstanceState
     */
    protected abstract void onCreateActivity(Bundle savedInstanceState);

    /**
     * 创建modelImpl 对象
     */
    protected abstract M createModelImpl();

    @Override
    protected void onResume() {
        super.onResume();
//        if (null!=mModelImpl){
//            mModelImpl.attachView((V) this);
//        }
    }

    @Override
    protected void onDestroy() {
//        if (null!=mModelImpl){
//            mModelImpl.detachView();
//        }
        super.onDestroy();
    }

    public void showShortToast(String msg) {
        Toast.makeText(BaseActivity.this, msg, Toast.LENGTH_SHORT).show();
    }
    public void showLongToast(String msg) {
        Toast.makeText(BaseActivity.this, msg, Toast.LENGTH_LONG).show();
    }
}

package com.mmbao.saas.base;

import android.content.Context;
import android.util.Log;

import java.lang.ref.Reference;
import java.lang.ref.SoftReference;

/**
 * Description:com.mmbao.saas.base类
 * Created by Administrator on 2018/1/28.
 * Maxim:There is no smoke without fire
 */

public abstract class BaseModelImpl<M> {

    private Context context;

    public BaseModelImpl(Context context) {
        this.context = context;
    }

    protected BaseModelImpl() {
    }

    //View接口类型的软引用
    public Reference<M> mViewRef ;

    public void attachView(M view){
        mViewRef = new SoftReference<M>(view);
        Log.i("dota","mViewRef ========"+mViewRef);
        Log.i("dota","view ========"+view);
    }

    protected M getView(){
        Log.i("dota","mViewRef ========"+mViewRef);
        if (isViewAttached()){
            return mViewRef.get();
        }else {
            return null;//TODO   此处有问题 有异常时走上面，无异常时走此处  应该返回什么
        }
    }

    public boolean isViewAttached(){
        return mViewRef != null && mViewRef.get() !=null;
    }

    public void detachView(){
        if (mViewRef !=null){
            mViewRef.clear();
        }
    }
}

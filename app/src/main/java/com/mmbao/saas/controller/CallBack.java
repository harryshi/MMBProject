package com.mmbao.saas.controller;

/**
 * Description:com.mmbao.saas.model类
 * Created by Administrator on 2018/1/28.
 * Maxim:There is no smoke without fire
 */

public abstract class CallBack<T> {
    public abstract void onResponse(T t);

    public abstract void onFailure(String errorInfo);

    public abstract void timeOut();
}

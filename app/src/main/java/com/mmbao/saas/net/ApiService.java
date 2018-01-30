package com.mmbao.saas.net;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

/**
 * Description:com.mmbao.saas.net类
 * Created by Administrator on 2018/1/27.
 * Maxim:There is no smoke without fire
 */

public interface ApiService {
    //登录
    @GET("saas/v1/user/login.html")
    Call<JsonObject> login(@Query("username") String userName, @Query("password") String psw, @Query("userid") String userId, @Query("channelid") String channelId, @Query("devicetype") String deviceType);

    //产品列表—购物车库存
    @GET("saas/v2/product/getInventory.html")
    Call<JsonObject> getSalesAttribute(@Query("prtId") String prtId, @Query("str") String str, @Query("salesActId") String salesActId, @Query("skuId") String skuId);
    //产品列表—加入购物车
    @GET("saas/v1/cart/addToCart.html")
    Call<JsonObject> addToCart(@Query("shopId") String shopId, @Query("productId") String prtId, @Query("prtSkuId") String skuId, @Query("num") String temp_count);

    //产品列表—获取产品列表
    @GET
     Call<JsonObject> getProduct(@Url String url);
}
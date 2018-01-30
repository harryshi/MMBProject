package com.mmbao.saas.net;
import android.content.Context;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * BaseInterceptor
 * Created by DotaWang on 2017-05-24.
 */
public class BaseInterceptor implements Interceptor{
    private Map<String, String> headers;
    private Context mContext;
    public BaseInterceptor(Context context, Map<String, String> headers) {
        super();
        this.mContext = context;
        this.headers = headers;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {

        Request.Builder builder = chain.request()
                .newBuilder();

        if (headers != null && headers.size() > 0) {
            Set<String> keys = headers.keySet();
            for (String headerKey : keys) {
                builder.addHeader(headerKey, headers.get(headerKey)).build();
                System.out.print("headerKey = "+headerKey +"--headers.get(headerKey)= "+headers.get(headerKey));
            }
        }
//        builder.addHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
//        builder.addHeader("token", "");
//        builder.addHeader("User-Agent", "");
//        builder.addHeader("Cookie", "");
        return chain.proceed(builder.build());

    }
}
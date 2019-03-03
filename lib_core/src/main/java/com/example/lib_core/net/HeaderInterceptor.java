package com.example.lib_core.net;

import android.util.Log;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class HeaderInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request builder = chain.request().newBuilder()
//                .addHeader("userid",SpUtils.getString(App_2.getContex3t,"usetid",""))
                .addHeader("",null)
                .build();

        Log.i("================",builder.toString());

        return chain.proceed(builder);
    }
}

package com.logintest.pc.logintestapplication.http;

import android.content.Context;
import android.support.annotation.NonNull;


import com.logintest.pc.logintestapplication.MyApplication;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Leo on 2017/6/24.
 * http manager
 */

public class HttpClient {

    private static final int CASE_SIZE = 10 * 1024 * 1024; // 10 MiB
    private static final int TIME_OUT = 30;// Second
    private static OkHttpClient mOkHttpClient;

    public static ApiStores getApiStores() {
        if (mOkHttpClient == null) {
            initOkHttpClient();
        }
        Retrofit retrofit = new Retrofit.Builder()
                .client(mOkHttpClient)
                .baseUrl("http://172.16.1.203:3000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(ApiStores.class);
    }

    public static ApiStores getApiStores(String url) {
        if (mOkHttpClient == null) {
            initOkHttpClient();
        }
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .client(mOkHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(ApiStores.class);
    }

    private static void initOkHttpClient() {
        Interceptor headInterceptor = getHeadInterceptor();
        Cache cache = getCache();
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        mOkHttpClient = new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .connectTimeout(TIME_OUT, TimeUnit.SECONDS)//设置超时时间
                .readTimeout(TIME_OUT, TimeUnit.SECONDS) //设置读取超时时间
                .writeTimeout(TIME_OUT, TimeUnit.SECONDS) //设置写入超时时间
                .cache(cache) //缓存
                .addNetworkInterceptor(headInterceptor) //http请求头
                .retryOnConnectionFailure(false)
                .hostnameVerifier(new HostnameVerifier() {
                    @Override
                    public boolean verify(String hostname, SSLSession session) {
                        return hostname.equalsIgnoreCase("graph.facebook.com");

                    }
                })
                .build();
    }

    private static Interceptor getHeadInterceptor() {
        return new Interceptor() {
            @Override
            public Response intercept(@NonNull Chain chain) throws IOException {
                Request request = chain.request();
                Request.Builder builder = request.newBuilder();

                builder.addHeader("Content-Type", "application/json");
                builder.addHeader("Connection", "close");//解决请求http失败问题
                return chain.proceed(builder.build());
            }
        };
    }

    private static Cache getCache() {
        Context context = MyApplication.getMyApplicationContext();
        File httpCacheDirectory = new File(context.getCacheDir(), "responses");
        return new Cache(httpCacheDirectory, CASE_SIZE);
    }
}

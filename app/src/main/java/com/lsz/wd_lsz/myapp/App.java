package com.lsz.wd_lsz.myapp;

import android.app.Application;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.HashSet;
import java.util.Set;

import cn.jpush.android.api.JPushInterface;

public class App  extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        /*
        * 极光推送
        * */
        jiguan();

        /*
        *
        * imageloader加载图片
        *
        * */
        imageLoader2();


    }

    private void imageLoader2() {

        ImageLoader.getInstance().init(new ImageLoaderConfiguration.Builder(this)
                .memoryCacheSizePercentage(10)
                .diskCacheSize(20*1024*1024)
                .defaultDisplayImageOptions(new DisplayImageOptions.Builder()
                        .cacheInMemory(true)
                        .cacheOnDisk(true)
                        .build())
                .build());
    }

    private void jiguan() {

        //初始化sdk
        JPushInterface.setDebugMode(true);//正式版的时候设置false，关闭调试
        JPushInterface.init(this);

    }

}

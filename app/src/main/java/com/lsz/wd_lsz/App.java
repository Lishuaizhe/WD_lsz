package com.lsz.wd_lsz;

import android.app.Application;

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

    }

    private void jiguan() {

        //初始化sdk
        JPushInterface.setDebugMode(true);//正式版的时候设置false，关闭调试
        JPushInterface.init(this);

    }

}

package com.lsz.wd_lsz.mvp.regismvp;

import com.example.lib_core.common.Api;
import com.example.lib_core.net.OkhttpCallback;
import com.example.lib_core.net.OkhttpUtils;

import java.util.HashMap;

/*
* 注册m
* */
public class Registermodel implements Registercontract.RegisterModel {

    @Override
    public void SetRegisterList(HashMap<String, String> hashMap, OkhttpCallback okhttpCallback) {
        OkhttpUtils.getInstance().doPost(Api.ZHUCE_Z,hashMap,okhttpCallback);
    }
}

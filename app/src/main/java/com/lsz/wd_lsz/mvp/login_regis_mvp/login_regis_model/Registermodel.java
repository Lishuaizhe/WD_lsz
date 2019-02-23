package com.lsz.wd_lsz.mvp.login_regis_mvp.login_regis_model;

import com.example.lib_core.common.Api;
import com.example.lib_core.net.OkhttpCallback;
import com.example.lib_core.net.OkhttpUtils;
import com.lsz.wd_lsz.mvp.login_regis_mvp.login_regis_contract.Registercontract;

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

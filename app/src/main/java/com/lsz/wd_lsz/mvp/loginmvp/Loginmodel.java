package com.lsz.wd_lsz.mvp.loginmvp;

import com.example.lib_core.common.Api;
import com.example.lib_core.net.OkhttpCallback;
import com.example.lib_core.net.OkhttpUtils;

import java.util.HashMap;


public class Loginmodel  implements Logincontract.ILoginModel {

    @Override
    public void SetLoginList(HashMap<String, String> hashMap, OkhttpCallback okhttpCallback) {
        OkhttpUtils.getInstance().doPost(Api.LOGIN_L,hashMap,okhttpCallback);
    }
}

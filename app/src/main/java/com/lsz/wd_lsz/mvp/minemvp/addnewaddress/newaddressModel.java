package com.lsz.wd_lsz.mvp.minemvp.addnewaddress;

import com.example.lib_core.net.OkhttpCallback;
import com.example.lib_core.net.OkhttpUtils;

import java.util.HashMap;

public class newaddressModel implements newaddressContract.I_new_M {


    private String s="http://172.17.8.100/small/user/verify/v1/addReceiveAddress";

    @Override
    public void GetData(HashMap<String, String> hashMap, final CallBack callBack) {
        OkhttpUtils.getInstance().doPost(s, hashMap, new OkhttpCallback() {
            @Override
            public void failure(String msg) {
                callBack.Fuile(msg);
            }
            @Override
            public void success(String result) {
                callBack.Success(result);
            }
        });
    }

    public interface CallBack {
        void Success(String r);
        void Fuile(String s);
    }
}

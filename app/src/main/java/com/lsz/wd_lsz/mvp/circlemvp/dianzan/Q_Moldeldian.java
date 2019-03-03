package com.lsz.wd_lsz.mvp.circlemvp.dianzan;

import com.example.lib_core.net.OkhttpCallback;
import com.example.lib_core.net.OkhttpUtils;

import java.util.HashMap;

public class Q_Moldeldian implements Q_Contractdian.I_model {

    String s ="http://172.17.8.100/small/circle/verify/v1/addCircleGreat";


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
        void Success(String s);
        void Fuile(String s);
    }
}

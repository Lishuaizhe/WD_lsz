package com.lsz.wd_lsz.mvp.circlemvp.quanz;

import com.example.lib_core.net.OkhttpCallback;
import com.example.lib_core.net.OkhttpUtils;

import java.util.HashMap;

public class Q_Moldel implements Q_Contract.I_model {

    String s ="http://172.17.8.100/small/circle/v1/findCircleList";


    @Override
    public void GetData(HashMap<String, String> hashMap, final CallBack callBack) {
        OkhttpUtils.getInstance().doGet(s, hashMap, new OkhttpCallback() {
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

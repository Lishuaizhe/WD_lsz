package com.lsz.wd_lsz.mvp.minemvp.mycircle;

import com.example.lib_core.net.OkhttpCallback;
import com.example.lib_core.net.OkhttpUtils;

import java.util.HashMap;

public class Circle_model implements Circle_contract.m_c_m {


    private String s="http://172.17.8.100/small/circle/verify/v1/findMyCircleById";

    @Override
    public void GetData(HashMap<String, String> hashMap, final CallBack callBack) {
        OkhttpUtils.getInstance().doGet(s, hashMap, new OkhttpCallback() {
            @Override
            public void failure(String msg) {
                callBack.Fault(msg);
            }

            @Override
            public void success(String result) {
                callBack.Success(result);
            }
        });
    }

    public interface CallBack {
        void Success(String s);
        void Fault(String s);
    }

}

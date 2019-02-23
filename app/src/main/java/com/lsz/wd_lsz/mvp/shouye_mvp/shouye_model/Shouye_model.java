package com.lsz.wd_lsz.mvp.shouye_mvp.shouye_model;

import com.example.lib_core.net.OkhttpCallback;
import com.example.lib_core.net.OkhttpUtils;
import com.lsz.wd_lsz.mvp.shouye_mvp.shouye_contract.Shouye_contract;

import java.util.HashMap;

public class Shouye_model implements Shouye_contract.IshouYe_M1 {


    private String s="http://172.17.8.100/small/commodity/v1/bannerShow";

    @Override
    public void getData(HashMap<String, String> hashMap, final Shouye_modelCallBACK callBACK) {
        OkhttpUtils.getInstance().doGet(s, hashMap, new OkhttpCallback() {
            @Override
            public void failure(String msg) {
                callBACK.CuowuB(msg);
            }

            @Override
            public void success(String result) {
                callBACK.SuccessB(result);
            }
        });

    }

    public interface  Shouye_modelCallBACK{
        void SuccessB(String s);
        void CuowuB(String s);
    }
}

package com.lsz.wd_lsz.mvp.homemvp.tanchuang2;

import com.example.lib_core.net.OkhttpCallback;
import com.example.lib_core.net.OkhttpUtils;

import java.util.HashMap;

public class PopuModel2 implements PopuContract2.IPopu_m{

    String s="http://172.17.8.100/small/commodity/v1/findSecondCategory";

    @Override
    public void getData(HashMap<String, String> hashMap, final Xiangq modelBack) {
        OkhttpUtils.getInstance().doGet(s, hashMap, new OkhttpCallback() {
            @Override
            public void failure(String msg) {
                modelBack.xFuile(msg);
            }

            @Override
            public void success(String result) {
                modelBack.xSuccess(result);
            }
        });
    }

    interface Xiangq{
        void xSuccess(String s);
        void xFuile(String s);
    }


}

package com.lsz.wd_lsz.mvp.homemvp.tanchuang;

import com.example.lib_core.net.OkhttpCallback;
import com.example.lib_core.net.OkhttpUtils;
import com.lsz.wd_lsz.mvp.homemvp.details.DetailsContract;

import java.util.HashMap;

public class PopuModel implements PopuContract.IPopu_m{

    String s="http://172.17.8.100/small/commodity/v1/findFirstCategory";

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

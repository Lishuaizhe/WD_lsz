package com.lsz.wd_lsz.mvp.homemvp.addtocart;


import com.example.lib_core.net.OkhttpCallback;
import com.example.lib_core.net.OkhttpUtils;

import java.util.Map;

public class JiaGouModel implements JiaGouContract.IcJia_M {

    private String a="http://172.17.8.100/small/order/verify/v1/syncShoppingCart";

    @Override
    public void getData(Map<String, Object> hashMap, final JiaGouCallBack callBack) {
        OkhttpUtils.getInstance().doPut(a, hashMap, new OkhttpCallback() {
            @Override
            public void failure(String msg) {
                callBack.Cuowugou(msg);
            }

            @Override
            public void success(String result) {
                callBack.Successgou(result);
            }
        });
    }


    public interface JiaGouCallBack {
        void Successgou(String s);
        void Cuowugou(String s);
    }
}

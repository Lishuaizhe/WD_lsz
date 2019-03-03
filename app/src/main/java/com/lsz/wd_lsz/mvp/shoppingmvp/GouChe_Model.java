package com.lsz.wd_lsz.mvp.shoppingmvp;

import com.example.lib_core.net.OkhttpCallback;
import com.example.lib_core.net.OkhttpUtils;

import java.util.HashMap;

public class GouChe_Model implements GouChe_Contract.IG_m {

    private String a="http://172.17.8.100/small/order/verify/v1/findShoppingCart";

    @Override
    public void GetData(HashMap<String, String> hashMap, final GouChe_Model_CallBack callBack) {
        OkhttpUtils.getInstance().doGet(a, hashMap, new OkhttpCallback() {
            @Override
            public void failure(String msg) {
                callBack.Fuil(msg);
            }

            @Override
            public void success(String result) {
                callBack.Success(result);
            }
        });
    }

    public interface GouChe_Model_CallBack{
        void Success(String s);
        void Fuil(String s);
    }
}

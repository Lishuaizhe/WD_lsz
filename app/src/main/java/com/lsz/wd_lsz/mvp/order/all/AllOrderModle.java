package com.lsz.wd_lsz.mvp.order.all;

import com.example.lib_core.net.OkhttpCallback;
import com.example.lib_core.net.OkhttpUtils;
import java.util.HashMap;

public class AllOrderModle implements AllOrderContact.I_All_M {


    private String s="http://172.17.8.100/small/order/verify/v1/findOrderListByStatus";


    @Override
    public void GetData(HashMap<String, String> hashMap, final AllOrderModle.CallBack callBack) {
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
        void Success(String r);
        void Fuile(String s);
    }
}

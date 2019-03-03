package com.lsz.wd_lsz.mvp.homemvp.homelist;

import com.example.lib_core.net.OkhttpCallback;
import com.example.lib_core.net.OkhttpUtils;

import java.util.HashMap;

public class HomeListModel implements HomeListContract.IshouYe_M {

    private String a="http://172.17.8.100/small/commodity/v1/commodityList";

    @Override
    public void getData(HashMap<String, String> hashMap, final ShouYeModelBack modelBack) {

        OkhttpUtils.getInstance().doGet(a, hashMap, new OkhttpCallback() {
            @Override
            public void failure(String msg) {
                modelBack.Cuowu(msg);
            }
            @Override
            public void success(String result) {
                modelBack.Success(result);
            }
        });
    }

    public interface ShouYeModelBack {
        void Success(String s);
        void Cuowu(String s);
    }
}

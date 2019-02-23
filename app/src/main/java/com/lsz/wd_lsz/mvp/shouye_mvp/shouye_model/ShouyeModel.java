package com.lsz.wd_lsz.mvp.shouye_mvp.shouye_model;

import com.example.lib_core.net.OkhttpCallback;
import com.example.lib_core.net.OkhttpUtils;
import com.lsz.wd_lsz.mvp.shouye_mvp.shouye_contract.ShouyeContract;

import java.util.HashMap;

public class ShouyeModel implements ShouyeContract.IshouYe_M {

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

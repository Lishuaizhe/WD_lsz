package com.lsz.wd_lsz.mvp.login_regis_mvp.login_regis_persenter;


import com.example.lib_core.net.OkhttpCallback;
import com.lsz.wd_lsz.mvp.login_regis_mvp.login_regis_contract.Logincontract;

import java.util.HashMap;

public class Loginpresenter extends Logincontract.ILoginPersenter {

    @Override
    public void setLoginList(HashMap<String, String> hashMap) {

        model.SetLoginList(hashMap, new OkhttpCallback() {
            @Override
            public void failure(String msg) {
                view.onFail(msg);
            }

            @Override
            public void success(String result) {
                view.onsuccess(result);
            }
        });
    }
}
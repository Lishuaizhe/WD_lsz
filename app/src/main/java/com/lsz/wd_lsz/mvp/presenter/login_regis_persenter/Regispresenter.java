package com.lsz.wd_lsz.mvp.presenter.login_regis_persenter;


import com.example.lib_core.net.OkhttpCallback;
import com.lsz.wd_lsz.mvp.contract.login_regis_contract.Registercontract;

import java.util.HashMap;

public class Regispresenter extends Registercontract.RegisterPersenter {

    @Override
    public void setRegisterList(HashMap<String, String> hashMap) {
        model.SetRegisterList(hashMap, new OkhttpCallback() {
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

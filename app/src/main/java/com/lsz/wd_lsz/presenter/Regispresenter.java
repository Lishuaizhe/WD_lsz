package com.lsz.wd_lsz.presenter;


import com.example.lib_core.net.OkhttpCallback;
import com.lsz.wd_lsz.contract.Logincontract;
import com.lsz.wd_lsz.contract.Registercontract;

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

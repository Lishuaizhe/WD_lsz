package com.lsz.wd_lsz.mvp.regismvp;


import com.example.lib_core.net.OkhttpCallback;

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

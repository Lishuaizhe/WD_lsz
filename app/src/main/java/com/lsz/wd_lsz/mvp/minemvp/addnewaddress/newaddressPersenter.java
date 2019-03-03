package com.lsz.wd_lsz.mvp.minemvp.addnewaddress;

import java.util.HashMap;

public class newaddressPersenter extends newaddressContract.I_new_P{

    private newaddressModel addressModel;
    private newaddressContract.I_new_V view;

    public newaddressPersenter(newaddressContract.I_new_V view) {
        this.view = view;
        addressModel = new newaddressModel();
    }

    @Override
   public void GetData(HashMap<String, String> hashMap) {
        addressModel.GetData(hashMap, new newaddressModel.CallBack() {
            @Override
            public void Success(String r) {
                view.Success(r);
            }

            @Override
            public void Fuile(String s) {
                view.Fuile(s);
            }
        });
    }
}

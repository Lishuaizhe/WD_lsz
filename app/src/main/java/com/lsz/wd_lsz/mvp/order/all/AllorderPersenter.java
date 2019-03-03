package com.lsz.wd_lsz.mvp.order.all;

import com.lsz.wd_lsz.mvp.minemvp.address.AddressContract;
import com.lsz.wd_lsz.mvp.minemvp.address.AddressModel;

import java.util.HashMap;

public class AllorderPersenter extends AllOrderContact.I_All_P{


    private AllOrderModle modle;

    private AllOrderContact.I_All_V view;

    public AllorderPersenter(AllOrderContact.I_All_V view) {
        this.view = view;
        modle =  new AllOrderModle();
    }

    @Override
   public void GetData(HashMap<String, String> hashMap) {
        modle.GetData(hashMap, new AllOrderModle.CallBack() {
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

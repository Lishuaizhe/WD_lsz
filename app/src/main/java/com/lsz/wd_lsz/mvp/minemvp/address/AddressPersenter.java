package com.lsz.wd_lsz.mvp.minemvp.address;

import java.util.HashMap;

public class AddressPersenter extends AddressContract.I_address_P{

    private AddressModel addressModel;
    private AddressContract.I_address_V view;

    public AddressPersenter(AddressContract.I_address_V view) {
        this.view = view;
        addressModel = new AddressModel();
    }
    @Override
   public void GetData(HashMap<String, String> hashMap) {
        addressModel.GetData(hashMap, new AddressModel.CallBack() {
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

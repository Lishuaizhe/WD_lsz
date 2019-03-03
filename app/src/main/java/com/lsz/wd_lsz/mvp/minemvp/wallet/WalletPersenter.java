package com.lsz.wd_lsz.mvp.minemvp.wallet;

import java.util.HashMap;

public class WalletPersenter extends WalletContract.Wallet_p{

    private WalletContract.Wallet_v view;
    private WalletModel model;

    public WalletPersenter(WalletContract.Wallet_v view) {
        this.view = view;
        model = new WalletModel();
    }

    @Override
   public void GetData(HashMap<String, String> hashMap) {
        model.GetData(hashMap, new WalletModel.CallBack() {
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

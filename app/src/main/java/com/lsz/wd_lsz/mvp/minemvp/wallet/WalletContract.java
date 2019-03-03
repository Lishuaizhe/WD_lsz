package com.lsz.wd_lsz.mvp.minemvp.wallet;

import com.lsz.wd_lsz.entiey.mineentity.Wallet;

import java.util.HashMap;

public interface WalletContract {

    abstract  class  Wallet_p{
        abstract  void  GetData(HashMap<String,String> hashMap);
    }

    interface Wallet_m{
        void GetData(HashMap<String, String> hashMap, WalletModel.CallBack callBack);
    }

    interface Wallet_v{
        void Success(String resut);
        void Fuile(String msg);
    }




}

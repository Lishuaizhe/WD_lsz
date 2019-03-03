package com.lsz.wd_lsz.mvp.minemvp.address;

import java.util.HashMap;

public interface AddressContract {

    abstract  class  I_address_P{
        abstract  void  GetData(HashMap<String,String> hashMap);
    }

    interface I_address_M{
        void GetData(HashMap<String, String> hashMap, AddressModel.CallBack callBack);
    }

    interface I_address_V{
        void Success(String resut);
        void Fuile(String msg);
    }




}

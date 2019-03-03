package com.lsz.wd_lsz.mvp.order.all;

import com.lsz.wd_lsz.mvp.minemvp.address.AddressModel;

import java.util.HashMap;

public interface AllOrderContact {

    abstract  class  I_All_P{
        abstract  void  GetData(HashMap<String,String> hashMap);
    }

    interface I_All_M{
        void GetData(HashMap<String, String> hashMap, AllOrderModle.CallBack callBack);
    }

    interface I_All_V{
        void Success(String resut);
        void Fuile(String msg);
    }




}

package com.lsz.wd_lsz.mvp.minemvp.addnewaddress;

import java.util.HashMap;

public interface newaddressContract {

    abstract  class  I_new_P{
        abstract  void  GetData(HashMap<String,String> hashMap);
    }

    interface I_new_M{
        void GetData(HashMap<String, String> hashMap, newaddressModel.CallBack callBack);
    }

    interface I_new_V{
        void Success(String resut);
        void Fuile(String msg);
    }




}

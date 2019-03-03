package com.lsz.wd_lsz.mvp.minemvp.mine;

import java.util.HashMap;

public interface MineContract {

    abstract  class  I_p{
        abstract  void  GetData(HashMap<String,String> hashMap);
    }

    interface I_m{
        void GetData(HashMap<String,String> hashMap,MineModel.CallBack callBack);
    }

    interface I_v{
        void Success(String resut);
        void Fuile(String msg);
    }




}

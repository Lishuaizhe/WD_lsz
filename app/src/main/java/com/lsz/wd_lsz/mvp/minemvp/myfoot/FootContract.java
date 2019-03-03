package com.lsz.wd_lsz.mvp.minemvp.myfoot;

import com.lsz.wd_lsz.mvp.minemvp.mine.MineModel;

import java.util.HashMap;

public interface FootContract {

    abstract  class  Foot_p{
        abstract  void  GetData(HashMap<String,String> hashMap);
    }

    interface Foot_m{
        void GetData(HashMap<String, String> hashMap, FootModel.CallBack callBack);
    }

    interface Foot_v{
        void Successf(String resut);
        void Fuilef(String msg);
    }




}

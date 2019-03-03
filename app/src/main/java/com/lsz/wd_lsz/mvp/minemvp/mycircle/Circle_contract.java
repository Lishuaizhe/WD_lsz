package com.lsz.wd_lsz.mvp.minemvp.mycircle;

import java.util.HashMap;

public interface Circle_contract {

    abstract class m_c_p{
        abstract void GetData(HashMap<String,String> hashMap);
    }

    interface m_c_v{
        void Success(String s);
        void Fault(String s);
    }

    interface m_c_m{
        void GetData(HashMap<String,String> hashMap,Circle_model.CallBack callBack);
    }



}

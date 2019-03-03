package com.lsz.wd_lsz.mvp.circlemvp.dianzan;

import java.util.HashMap;

public interface Q_Contractdian {


    abstract class I_persenter{
        protected abstract void GetData(HashMap<String, String> hashMap);
    }

    interface I_model{
        void GetData(HashMap<String, String> hashMap, Q_Moldeldian.CallBack callBack);
    }

    interface I_Viewdina{
        void Successdian(String s);
        void Fuiledian(String s);
    }


}

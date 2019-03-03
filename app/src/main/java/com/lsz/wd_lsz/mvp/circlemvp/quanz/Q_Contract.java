package com.lsz.wd_lsz.mvp.circlemvp.quanz;

import java.util.HashMap;

public interface Q_Contract {


    abstract class I_persenter{
        protected abstract void GetData(HashMap<String, String> hashMap);
    }

    interface I_model{
        void GetData(HashMap<String,String> hashMap, Q_Moldel.CallBack callBack);
    }

    interface I_View{
        void Success(String s);
        void Fuile(String s);
    }


}

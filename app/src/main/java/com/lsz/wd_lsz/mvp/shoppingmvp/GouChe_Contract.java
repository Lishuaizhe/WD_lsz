package com.lsz.wd_lsz.mvp.shoppingmvp;

import java.util.HashMap;

public interface GouChe_Contract {

    abstract class IG_p{
        public abstract void GetData(HashMap<String, String> hashMap);
    }

    interface IG_m{
        void GetData(HashMap<String,String> hashMap, GouChe_Model.GouChe_Model_CallBack callBack);
    }

    interface IG_v{
        void Success(String s);
        void Fuil(String s);
    }

}

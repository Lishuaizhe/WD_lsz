package com.lsz.wd_lsz.mvp.homemvp.banner;

import java.util.HashMap;

public interface Bannercontract {

    abstract class IshouYe_P1{
        protected abstract void getData(HashMap<String, String> hashMap);
    }

    interface IshouYe_M1{
        void getData(HashMap<String,String> hashMap, Bannermodel.Shouye_modelCallBACK callBACK);
    }

    interface IshouYe_V1{
        void Success1(String s);
        void Cuow1(String s);
    }

}

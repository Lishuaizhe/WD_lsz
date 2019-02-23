package com.lsz.wd_lsz.mvp.shouye_mvp.shouye_contract;

import com.lsz.wd_lsz.mvp.shouye_mvp.shouye_model.Shouye_model;

import java.util.HashMap;

public interface Shouye_contract {

    abstract class IshouYe_P1{
        protected abstract void getData(HashMap<String, String> hashMap);
    }

    interface IshouYe_M1{
        void getData(HashMap<String,String> hashMap, Shouye_model.Shouye_modelCallBACK callBACK);
    }

    interface IshouYe_V1{
        void Success1(String s);
        void Cuow1(String s);
    }

}

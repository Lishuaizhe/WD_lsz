package com.lsz.wd_lsz.mvp.homemvp.tanchuang2;

import java.util.HashMap;

public interface PopuContract2 {

    abstract class IPopu_p{
        protected abstract void getData(HashMap<String, String> hashMap);
    }

    interface IPopu_m{
        void getData(HashMap<String, String> hashMap, PopuModel2.Xiangq modelBack);
    }

    interface IPopu_v2{
        void xsuccess2(String s);
        void xcuowu2(String s);
    }

}

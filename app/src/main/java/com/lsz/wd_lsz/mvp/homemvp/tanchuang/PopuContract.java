package com.lsz.wd_lsz.mvp.homemvp.tanchuang;

import com.lsz.wd_lsz.mvp.homemvp.details.DetailsModel;

import java.util.HashMap;

public interface PopuContract {

    abstract class IPopu_p{
        protected abstract void getData(HashMap<String, String> hashMap);
    }

    interface IPopu_m{
        void getData(HashMap<String, String> hashMap, PopuModel.Xiangq modelBack);
    }

    interface IPopu_v{
        void xsuccess(String s);
        void xcuowu(String s);
    }

}

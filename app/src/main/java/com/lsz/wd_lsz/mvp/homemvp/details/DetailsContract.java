package com.lsz.wd_lsz.mvp.homemvp.details;

import java.util.HashMap;

public interface DetailsContract {

    abstract class Ixiangqing_p{
        protected abstract void getData(HashMap<String, String> hashMap);
    }

    interface Ixiangqing_m{
        void getData(HashMap<String, String> hashMap,DetailsModel.Xiangq modelBack);
    }

    interface Ixiangqing_v{
        void xsuccess(String s);
        void xcuowu(String s);
    }

}

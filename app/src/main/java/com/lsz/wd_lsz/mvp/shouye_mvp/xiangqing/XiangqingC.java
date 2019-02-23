package com.lsz.wd_lsz.mvp.shouye_mvp.xiangqing;

import com.lsz.wd_lsz.mvp.shouye_mvp.chazhao.ShouyechazhaoModel;

import java.util.HashMap;

public interface XiangqingC {

    abstract class Ixiangqing_p{
        protected abstract void getData(HashMap<String, String> hashMap);
    }

    interface Ixiangqing_m{
        void getData(HashMap<String, String> hashMap,XiangqingM.Xiangq modelBack);
    }

    interface Ixiangqing_v{
        void xsuccess(String s);
        void xcuowu(String s);
    }

}

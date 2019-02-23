package com.lsz.wd_lsz.mvp.shouye_mvp.chazhao;

import com.lsz.wd_lsz.mvp.shouye_mvp.shouye_model.ShouyeModel;

import java.util.HashMap;

public interface ShouyechazhaoContract {

    abstract class IcshouYe_P{
        protected abstract void getData(HashMap<String, String> hashMap);
    }

    interface IcshouYe_M{
        void getData(HashMap<String, String> hashMap, ShouyechazhaoModel.ShouYechazhaoModelBack modelBack);
    }

    interface IcshouYe_V{
        void Successc(String s);
        void Cuowc(String s);
    }


}

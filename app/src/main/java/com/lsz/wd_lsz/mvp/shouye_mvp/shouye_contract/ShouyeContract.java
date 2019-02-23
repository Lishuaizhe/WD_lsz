package com.lsz.wd_lsz.mvp.shouye_mvp.shouye_contract;

import com.lsz.wd_lsz.mvp.shouye_mvp.shouye_model.ShouyeModel;

import java.util.HashMap;

public interface ShouyeContract {

    abstract class IshouYe_P{
        protected abstract void getData(HashMap<String, String> hashMap);
    }

    interface IshouYe_M{
        void getData(HashMap<String,String> hashMap, ShouyeModel.ShouYeModelBack modelBack);
    }

    interface IshouYe_V{
        void Success(String s);
        void Cuow(String s);
    }


}

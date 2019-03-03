package com.lsz.wd_lsz.mvp.homemvp.addtocart;

import java.util.Map;

public interface JiaGouContract {

    abstract class IcJia_P{
        protected abstract void getData(Map<String, Object> hashMap);
    }

    interface IcJia_M{
        void getData(Map<String, Object> hashMap, JiaGouModel.JiaGouCallBack callBack);
    }

    interface IcJia_V{
        void Successjia(String s);
        void Cuowjia(String s);
    }


}

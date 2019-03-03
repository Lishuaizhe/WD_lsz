package com.lsz.wd_lsz.mvp.homemvp.homelist;

import java.util.HashMap;

public interface HomeListContract {

    abstract class IshouYe_P{
        protected abstract void getData(HashMap<String, String> hashMap);
    }

    interface IshouYe_M{
        void getData(HashMap<String,String> hashMap, HomeListModel.ShouYeModelBack modelBack);
    }

    interface IshouYe_V{
        void Success(String s);
        void Cuow(String s);
    }


}

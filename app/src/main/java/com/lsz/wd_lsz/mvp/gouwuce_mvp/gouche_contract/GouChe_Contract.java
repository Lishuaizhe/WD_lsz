package com.lsz.wd_lsz.mvp.gouwuce_mvp.gouche_contract;

import com.lsz.wd_lsz.entiey.gouche_entity.LBean_G;
import com.lsz.wd_lsz.mvp.gouwuce_mvp.gouche_model.GouChe_Model;

import java.util.HashMap;
import java.util.List;

public interface GouChe_Contract {

    abstract class IG_p{
        public abstract void GetData(HashMap<String, String> hashMap);
    }

    interface IG_m{
        void GetData(HashMap<String,String> hashMap, GouChe_Model.GouChe_Model_CallBack callBack);
    }

    interface IG_v{
        void Success(String s);
        void Fuil(String s);
    }

}

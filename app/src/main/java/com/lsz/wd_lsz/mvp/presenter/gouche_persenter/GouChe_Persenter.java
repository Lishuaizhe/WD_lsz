package com.lsz.wd_lsz.mvp.presenter.gouche_persenter;

import com.google.gson.Gson;
import com.lsz.wd_lsz.mvp.contract.gouche_contract.GouChe_Contract;
import com.lsz.wd_lsz.entiey.gouche_entity.LBean_G;
import com.lsz.wd_lsz.mvp.model.gouche_model.GouChe_Model;

import java.util.HashMap;

public class GouChe_Persenter extends GouChe_Contract.IG_p {

    private GouChe_Model model;
    private GouChe_Contract.IG_v view;

    public GouChe_Persenter(GouChe_Contract.IG_v view) {
        this.view = view;
        model = new GouChe_Model();
    }

    @Override
    public void GetData(HashMap<String, String> hashMap) {
        model.GetData(hashMap, new GouChe_Model.GouChe_Model_CallBack() {
            @Override
            public void Success(String s) {
                LBean_G lBean_g = new Gson().fromJson(s, LBean_G.class);
                view.Success(lBean_g.data);
            }

            @Override
            public void Fuil(String s) {
                view.Fuil(s);
            }
        });
    }
}

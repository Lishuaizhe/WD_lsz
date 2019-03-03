package com.lsz.wd_lsz.mvp.shoppingmvp;

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
                view.Success(s);
            }

            @Override
            public void Fuil(String s) {
                view.Fuil(s);
            }
        });
    }
}

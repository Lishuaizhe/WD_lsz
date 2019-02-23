package com.lsz.wd_lsz.mvp.shouye_mvp.shouye_persenter;

import com.lsz.wd_lsz.mvp.shouye_mvp.shouye_contract.Shouye_contract;
import com.lsz.wd_lsz.mvp.shouye_mvp.shouye_model.Shouye_model;

import java.util.HashMap;

public class Shouye_pesenter extends Shouye_contract.IshouYe_P1 {

    private Shouye_model shouye_model;
    private Shouye_contract.IshouYe_V1 view;

    public Shouye_pesenter(Shouye_contract.IshouYe_V1 view) {
        this.view = view;
        shouye_model = new Shouye_model();
    }

    @Override
    public void getData(HashMap<String, String> hashMap) {
        shouye_model.getData(hashMap, new Shouye_model.Shouye_modelCallBACK() {
            @Override
            public void SuccessB(String s) {
                view.Success1(s);
            }

            @Override
            public void CuowuB(String s) {
                view.Cuow1(s);
            }
        });
    }
}

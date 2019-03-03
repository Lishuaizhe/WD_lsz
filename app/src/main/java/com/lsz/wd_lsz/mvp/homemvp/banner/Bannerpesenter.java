package com.lsz.wd_lsz.mvp.homemvp.banner;

import java.util.HashMap;

public class Bannerpesenter extends Bannercontract.IshouYe_P1 {

    private Bannermodel shouye_bannermodel;
    private Bannercontract.IshouYe_V1 view;

    public Bannerpesenter(Bannercontract.IshouYe_V1 view) {
        this.view = view;
        shouye_bannermodel = new Bannermodel();
    }

    @Override
    public void getData(HashMap<String, String> hashMap) {
        shouye_bannermodel.getData(hashMap, new Bannermodel.Shouye_modelCallBACK() {
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

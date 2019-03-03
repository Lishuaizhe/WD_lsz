package com.lsz.wd_lsz.mvp.minemvp.mycircle;

import java.util.HashMap;

public class Circle_persenter extends Circle_contract.m_c_p {

    private Circle_contract.m_c_v view;
    private Circle_model model;

    public Circle_persenter(Circle_contract.m_c_v view) {
        this.view = view;
        model = new Circle_model();
    }

    @Override
    public void GetData(HashMap<String, String> hashMap) {
        model.GetData(hashMap, new Circle_model.CallBack() {
            @Override
            public void Success(String s) {
                view.Success(s);
            }

            @Override
            public void Fault(String s) {
                view.Fault(s);
            }
        });
    }
}

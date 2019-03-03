package com.lsz.wd_lsz.mvp.homemvp.addtocart;

import java.util.Map;

public class JiaGouPersenter extends JiaGouContract.IcJia_P {


    public JiaGouModel model;
    private JiaGouContract.IcJia_V view;

    public JiaGouPersenter(JiaGouContract.IcJia_V view) {
        this.view = view;
        model = new JiaGouModel();
    }


    @Override
    public void getData(Map<String, Object> hashMap) {
        model.getData(hashMap, new JiaGouModel.JiaGouCallBack() {
            @Override
            public void Successgou(String s) {
                view.Successjia(s);
            }

            @Override
            public void Cuowugou(String s) {
                view.Cuowjia(s);
            }
        });
    }
}

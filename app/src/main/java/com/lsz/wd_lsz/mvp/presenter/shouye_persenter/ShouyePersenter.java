package com.lsz.wd_lsz.mvp.presenter.shouye_persenter;

import com.lsz.wd_lsz.mvp.contract.shouye_contract.ShouyeContract;
import com.lsz.wd_lsz.mvp.model.shouye_model.ShouyeModel;

import java.util.HashMap;

public class ShouyePersenter extends ShouyeContract.IshouYe_P {


    private ShouyeModel model;
    private ShouyeContract.IshouYe_V view;

    public ShouyePersenter(ShouyeContract.IshouYe_V view) {
        this.view = view;
        model = new ShouyeModel();
    }


    @Override
    public void getData(HashMap<String, String> hashMap) {
        model.getData(hashMap, new ShouyeModel.ShouYeModelBack() {
            @Override
            public void Success(String s) {
                view.Success(s);
            }

            @Override
            public void Cuowu(String s) {
                view.Cuow(s);
            }
        });

    }
}

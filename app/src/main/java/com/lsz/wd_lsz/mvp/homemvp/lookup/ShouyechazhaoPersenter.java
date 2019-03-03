package com.lsz.wd_lsz.mvp.homemvp.lookup;

import java.util.HashMap;

public class ShouyechazhaoPersenter extends ShouyechazhaoContract.IcshouYe_P {


    public ShouyechazhaoModel model;
    private ShouyechazhaoContract.IcshouYe_V view;

    public ShouyechazhaoPersenter(ShouyechazhaoContract.IcshouYe_V view) {
        this.view = view;
        model = new ShouyechazhaoModel();
    }

    @Override
    public void getData(HashMap<String, String> hashMap) {
        model.getData(hashMap, new ShouyechazhaoModel.ShouYechazhaoModelBack(){
            @Override
            public void Success(String s) {
                view.Successc(s);
            }

            @Override
            public void Cuowu(String s) {
                view.Cuowc(s);
            }
        });

    }
}

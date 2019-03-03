package com.lsz.wd_lsz.mvp.minemvp.myfoot;

import com.lsz.wd_lsz.mvp.minemvp.mine.MineContract;
import com.lsz.wd_lsz.mvp.minemvp.mine.MineModel;

import java.util.HashMap;

public class FootPersenter extends FootContract.Foot_p{

    public FootModel model;
    public FootContract.Foot_v view;

    public FootPersenter(FootContract.Foot_v view) {
        this.view = view;
        model = new FootModel();
    }

    @Override
   public void GetData(HashMap<String, String> hashMap) {
        model.GetData(hashMap, new FootModel.CallBack() {
            @Override
            public void Success(String r) {
                view.Successf(r);
            }

            @Override
            public void Fuile(String s) {
                view.Fuilef(s);
            }
        });
    }
}

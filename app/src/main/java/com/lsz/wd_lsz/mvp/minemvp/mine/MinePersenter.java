package com.lsz.wd_lsz.mvp.minemvp.mine;

import java.util.HashMap;

public class MinePersenter extends MineContract.I_p{

    private MineModel mineModel;
    private MineContract.I_v view;

    public MinePersenter(MineContract.I_v view) {
        this.view = view;
        mineModel = new MineModel();
    }

    @Override
   public void GetData(HashMap<String, String> hashMap) {
        mineModel.GetData(hashMap, new MineModel.CallBack() {
            @Override
            public void Success(String r) {
                view.Success(r);
            }

            @Override
            public void Fuile(String s) {
                view.Fuile(s);
            }
        });
    }
}

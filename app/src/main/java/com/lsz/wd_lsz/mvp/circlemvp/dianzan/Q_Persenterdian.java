package com.lsz.wd_lsz.mvp.circlemvp.dianzan;

import java.util.HashMap;

public class Q_Persenterdian extends Q_Contractdian.I_persenter {

    private Q_Moldeldian moldel;
    private Q_Contractdian.I_Viewdina view;

    public Q_Persenterdian(Q_Contractdian.I_Viewdina view) {
        this.view = view;
        moldel =  new Q_Moldeldian();
    }

    @Override
    public void GetData(HashMap<String, String> hashMap) {
        moldel.GetData(hashMap, new Q_Moldeldian.CallBack() {
            @Override
            public void Success(String s) {
                view.Successdian(s);
            }

            @Override
            public void Fuile(String s) {
                view.Fuiledian(s);
            }
        });
    }
}

package com.lsz.wd_lsz.mvp.circlemvp.quanz;

import java.util.HashMap;

public class Q_Persenter extends Q_Contract.I_persenter {

    private Q_Moldel moldel;
    private Q_Contract.I_View view;

    public Q_Persenter(Q_Contract.I_View view) {
        this.view = view;
        moldel =  new Q_Moldel();
    }

    @Override
    public void GetData(HashMap<String, String> hashMap) {
        moldel.GetData(hashMap, new Q_Moldel.CallBack() {
            @Override
            public void Success(String s) {
                view.Success(s);
            }

            @Override
            public void Fuile(String s) {
                view.Fuile(s);
            }
        });
    }
}

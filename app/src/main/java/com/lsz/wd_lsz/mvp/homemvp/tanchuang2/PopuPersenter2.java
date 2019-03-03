package com.lsz.wd_lsz.mvp.homemvp.tanchuang2;

import com.lsz.wd_lsz.mvp.homemvp.details.DetailsContract;
import com.lsz.wd_lsz.mvp.homemvp.tanchuang.PopuContract;

import java.util.HashMap;

public class PopuPersenter2 extends PopuContract.IPopu_p {


    private PopuModel2 model;
    private PopuContract2.IPopu_v2 view;


    public PopuPersenter2(PopuContract2.IPopu_v2 view) {
        this.view = view;
        model = new PopuModel2();
    }

    @Override
    public void getData(HashMap<String, String> hashMap) {
        model.getData(hashMap, new PopuModel2.Xiangq() {
            @Override
            public void xSuccess(String s) {
                view.xsuccess2(s);
            }

            @Override
            public void xFuile(String s) {
                view.xcuowu2(s);
            }
        });

    }
}

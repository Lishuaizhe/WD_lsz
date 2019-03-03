package com.lsz.wd_lsz.mvp.homemvp.tanchuang;

import com.lsz.wd_lsz.mvp.homemvp.details.DetailsContract;
import com.lsz.wd_lsz.mvp.homemvp.details.DetailsModel;

import java.util.HashMap;

public class PopuPersenter extends DetailsContract.Ixiangqing_p {


    private PopuModel model;
    private PopuContract.IPopu_v view;

    public PopuPersenter(PopuContract.IPopu_v view) {
        this.view = view;
        model = new PopuModel();
    }

    @Override
    public void getData(HashMap<String, String> hashMap) {
        model.getData(hashMap, new PopuModel.Xiangq() {
            @Override
            public void xSuccess(String s) {
                view.xsuccess(s);
            }

            @Override
            public void xFuile(String s) {
                view.xcuowu(s);
            }
        });
    }
}

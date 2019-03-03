package com.lsz.wd_lsz.mvp.homemvp.details;

import java.util.HashMap;

public class DetailsPersenter extends DetailsContract.Ixiangqing_p {


    private DetailsModel model;
    private DetailsContract.Ixiangqing_v view;

    public DetailsPersenter(DetailsContract.Ixiangqing_v view) {
        this.view = view;
        model = new DetailsModel();
    }

    @Override
    public void getData(HashMap<String, String> hashMap) {
        model.getData(hashMap, new DetailsModel.Xiangq() {
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

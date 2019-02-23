package com.lsz.wd_lsz.mvp.shouye_mvp.xiangqing;

import com.lsz.wd_lsz.mvp.shouye_mvp.chazhao.ShouyechazhaoContract;
import com.lsz.wd_lsz.mvp.shouye_mvp.chazhao.ShouyechazhaoModel;

import java.util.HashMap;

public class XiangqingP extends XiangqingC.Ixiangqing_p {


    private XiangqingM model;
    private XiangqingC.Ixiangqing_v view;

    public XiangqingP(XiangqingC.Ixiangqing_v view) {
        this.view = view;
        model = new XiangqingM();
    }

    @Override
    public void getData(HashMap<String, String> hashMap) {
        model.getData(hashMap, new XiangqingM.Xiangq() {
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

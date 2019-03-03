package com.lsz.wd_lsz.mvp.homemvp.homelist;

import java.util.HashMap;

public class HomeListPersenter extends HomeListContract.IshouYe_P {


    private HomeListModel model;
    private HomeListContract.IshouYe_V view;

    public HomeListPersenter(HomeListContract.IshouYe_V view) {
        this.view = view;
        model = new HomeListModel();
    }


    @Override
    public void getData(HashMap<String, String> hashMap) {
        model.getData(hashMap, new HomeListModel.ShouYeModelBack() {
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

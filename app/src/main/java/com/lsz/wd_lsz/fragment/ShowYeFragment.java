package com.lsz.wd_lsz.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.lsz.wd_lsz.R;
import com.lsz.wd_lsz.adapter.shouye_adapter.ShouYe_adapter;
import com.lsz.wd_lsz.mvp.contract.shouye_contract.ShouyeContract;
import com.lsz.wd_lsz.entiey.Shouye;
import com.lsz.wd_lsz.mvp.presenter.shouye_persenter.ShouyePersenter;

import java.util.HashMap;

public class ShowYeFragment extends Fragment implements ShouyeContract.IshouYe_V {

    private ShouyePersenter persenter;
    private ShouYe_adapter adapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.showye,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initData();
    }

    private void initData() {
        persenter = new ShouyePersenter(this);
        persenter.getData(new HashMap<String, String>());
    }

    @Override
    public void Success(String s) {
        Shouye shouye = new Gson().fromJson(s, Shouye.class);
//        获取数据成功
    }

    @Override
    public void Cuow(String s) {

    }
}

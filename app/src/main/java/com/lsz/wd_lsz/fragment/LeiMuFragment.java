package com.lsz.wd_lsz.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.google.gson.Gson;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.lsz.wd_lsz.R;
import com.lsz.wd_lsz.adapter.gouche_adapter.My_adapter;
import com.lsz.wd_lsz.mvp.callback.CallUiBack;
import com.lsz.wd_lsz.mvp.gouwuce_mvp.gouche_contract.GouChe_Contract;
import com.lsz.wd_lsz.entiey.gouche_entity.LBean_G;
import com.lsz.wd_lsz.mvp.gouwuce_mvp.gouche_persenter.GouChe_Persenter;

import java.util.HashMap;
import java.util.List;

public class LeiMuFragment extends Fragment implements GouChe_Contract.IG_v,CallUiBack {

    private Button button;
    private CheckBox checkBox;
    private XRecyclerView xRecyclerView;
    private GouChe_Persenter persenter;
    private List<LBean_G.ResultBean> carts;
    private My_adapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.leimu,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        initData();
    }

    private void initView(View view) {
        button = view.findViewById(R.id.a_button);
        xRecyclerView = view.findViewById(R.id.a_x_recy_view);
        checkBox = view.findViewById(R.id.a_xuan);
    }

    private void initData() {
        persenter = new GouChe_Persenter(this);
        persenter.GetData(new HashMap<String, String>());
    }


    @Override
    public void Success(String s) {

        LBean_G lBean_g = new Gson().fromJson(s, LBean_G.class);
        if (lBean_g!=null) {
            adapter = new My_adapter(lBean_g.getResult(),getActivity());
            xRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            xRecyclerView.setAdapter(adapter);
        }
    }

    @Override
    public void Fuil(String s) {
        Toast.makeText(getContext(),s,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void ShuaXin() {

    }

    /*private void getPrace() {
        double a =0;
        for (LBean_G.Cart cart : carts) {
            for (LBean_G.Cart.Product product : cart.list) {
                if (product.isProductChecked){
                  a+=product.price*product.productNum;
                }
            }
        }
        checkBox.setText("￥："+a);
    }
*//*
    @Override
    public void ShuaXin() {
        getPrace();
    }*/
}

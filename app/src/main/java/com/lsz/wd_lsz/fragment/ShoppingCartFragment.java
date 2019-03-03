package com.lsz.wd_lsz.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.google.gson.Gson;
import com.lsz.wd_lsz.R;
import com.lsz.wd_lsz.adapter.shoppingadapter.ShoppingCartadapter;
import com.lsz.wd_lsz.callback.CallUiBack;
import com.lsz.wd_lsz.mvp.shoppingmvp.GouChe_Contract;
import com.lsz.wd_lsz.entiey.shoppingentity.ShoppingCatr;
import com.lsz.wd_lsz.mvp.shoppingmvp.GouChe_Persenter;

import java.util.HashMap;
import java.util.List;

public class ShoppingCartFragment extends Fragment implements GouChe_Contract.IG_v {

    private Button button;
    private CheckBox checkBox;
    private RecyclerView xRecyclerView;
    private GouChe_Persenter persenter;
    private List<ShoppingCatr.ResultBean> carts;
    private ShoppingCartadapter adapter;

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

        /*
        * 点击事件
        * */
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            }
        });

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
        ShoppingCatr lBean_g = new Gson().fromJson(s, ShoppingCatr.class);
        if (lBean_g!=null) {
            adapter = new ShoppingCartadapter(lBean_g.getResult(),getActivity());
            xRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            xRecyclerView.setAdapter(adapter);
        }
    }

    @Override
    public void Fuil(String s) {
        Toast.makeText(getContext(),s,Toast.LENGTH_SHORT).show();
    }
}

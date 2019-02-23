package com.lsz.wd_lsz.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.lsz.wd_lsz.R;
import com.lsz.wd_lsz.activity.xiangqingye.Main3Activity;
import com.lsz.wd_lsz.adapter.shouye_adapter.ShouYeAdapter;
import com.lsz.wd_lsz.entiey.shou_ye_entity.ShouyeBanner;
import com.lsz.wd_lsz.mvp.shouye_mvp.shouye_contract.ShouyeContract;
import com.lsz.wd_lsz.entiey.shou_ye_entity.Shouye;
import com.lsz.wd_lsz.mvp.shouye_mvp.shouye_contract.Shouye_contract;
import com.lsz.wd_lsz.mvp.shouye_mvp.shouye_persenter.ShouyePersenter;
import com.lsz.wd_lsz.mvp.shouye_mvp.shouye_persenter.Shouye_pesenter;

import java.util.HashMap;

public class ShowYeFragment extends Fragment implements ShouyeContract.IshouYe_V,Shouye_contract.IshouYe_V1 {

    private ShouyePersenter persenter;
    private ShouYeAdapter adapter;
    private Shouye_pesenter shouye_pesenter;
    private RecyclerView recyclerView1;
    private Shouye shouye;
    private ImageView sousuo;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.showye,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        initData();
        sousuo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),Main3Activity.class);
                intent.putExtra("name", 4+"");
                startActivity(intent);
            }
        });
    }

    private void initView(View view) {
        recyclerView1 = view.findViewById(R.id.a_x_recy_view02);
        sousuo = view.findViewById(R.id.sousu);
    }

    private void initData() {
        persenter = new ShouyePersenter(this);
        persenter.getData(new HashMap<String, String>());
        shouye_pesenter = new Shouye_pesenter(this);
        shouye_pesenter.getData(new HashMap<String, String>());
        recyclerView1.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new ShouYeAdapter(getActivity());
        recyclerView1.setAdapter(adapter);
    }

    @Override
    public void Success(String s) {
        /*
        * list数据
        * */
        recyclerView1.setLayoutManager(new LinearLayoutManager(getContext()));
        shouye = new Gson().fromJson(s, Shouye.class);
        //获取数据成功
        adapter.setList(shouye.getResult());
    }

    @Override
    public void Cuow(String s) {
        Toast.makeText(getActivity(),s,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void Success1(String s) {
        /*
        * banner轮播
        * */
        ShouyeBanner shouyeBanner = new Gson().fromJson(s, ShouyeBanner.class);
        adapter.setBanner1(shouyeBanner.getResult());
    }

    @Override
    public void Cuow1(String s) {
        Toast.makeText(getActivity(),s,Toast.LENGTH_SHORT).show();
    }

}

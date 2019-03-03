package com.lsz.wd_lsz.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.google.gson.Gson;
import com.lsz.wd_lsz.R;
import com.lsz.wd_lsz.activity.details.HomeListActivity;
import com.lsz.wd_lsz.adapter.homepageadapter.CategoryAdapter;
import com.lsz.wd_lsz.adapter.homepageadapter.CategoryAdapter2;
import com.lsz.wd_lsz.adapter.homepageadapter.HomePageAdapter;
import com.lsz.wd_lsz.entiey.homeentity.Category1;
import com.lsz.wd_lsz.entiey.homeentity.HomeBannerBean;
import com.lsz.wd_lsz.mvp.homemvp.homelist.HomeListContract;
import com.lsz.wd_lsz.entiey.homeentity.HomeListBean;
import com.lsz.wd_lsz.mvp.homemvp.banner.Bannercontract;
import com.lsz.wd_lsz.mvp.homemvp.homelist.HomeListPersenter;
import com.lsz.wd_lsz.mvp.homemvp.banner.Bannerpesenter;
import com.lsz.wd_lsz.mvp.homemvp.tanchuang.PopuContract;
import com.lsz.wd_lsz.mvp.homemvp.tanchuang.PopuPersenter;
import com.lsz.wd_lsz.mvp.homemvp.tanchuang2.PopuContract2;
import com.lsz.wd_lsz.mvp.homemvp.tanchuang2.PopuPersenter2;

import java.util.HashMap;

public class HomePageFragment extends Fragment implements HomeListContract.IshouYe_V,Bannercontract.IshouYe_V1,PopuContract.IPopu_v,PopuContract2.IPopu_v2 {

    private HomeListPersenter persenter;
    private HomePageAdapter adapter;
    private Bannerpesenter shouye_bannerpesenter;
    private RecyclerView recyclerView1;
    private RecyclerView recyclerView2;
    private RecyclerView recyclerView3;
    private HomeListBean homeListBean;
    private ImageView sousuo;
    private ImageView dianji;
    private PopuPersenter popuPersenter;
    private CategoryAdapter adapterca;
    private PopuPersenter2 persenter2;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.home,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        initData();
        recyclerView2.setVisibility(View.VISIBLE);
        sousuo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),HomeListActivity.class);
                intent.putExtra("name", 4+"");
                startActivity(intent);
            }
        });

        /*
         * 点击弹出窗
         * */
        dianji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerView2.setVisibility(View.VISIBLE);
                recyclerView1.setVisibility(View.GONE);
                popuPersenter.getData(new HashMap<String, String>());
            }
        });


        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerView2.setVisibility(View.GONE);
                recyclerView1.setVisibility(View.VISIBLE);
            }
        });

    }

    private void initView(View view) {
        recyclerView1 = view.findViewById(R.id.a_x_recy_view02);
        recyclerView2 = view.findViewById(R.id.a_x_recy_view03);
        recyclerView3 = view.findViewById(R.id.a_x_recy_view04);
        dianji = view.findViewById(R.id.dianji);
        sousuo = view.findViewById(R.id.sousu);
    }

    private void initData() {
        persenter = new HomeListPersenter(this);
        persenter.getData(new HashMap<String, String>());
        shouye_bannerpesenter = new Bannerpesenter(this);
        shouye_bannerpesenter.getData(new HashMap<String, String>());
        recyclerView1.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new HomePageAdapter(getActivity());
        recyclerView1.setAdapter(adapter);
        popuPersenter = new PopuPersenter(this);
        persenter2 = new PopuPersenter2(this);
    }

    @Override
    public void Success(String s) {
        /*
        * list数据
        * */
        recyclerView1.setLayoutManager(new LinearLayoutManager(getContext()));
        homeListBean = new Gson().fromJson(s, HomeListBean.class);
        //获取数据成功
        adapter.setList(homeListBean.getResult());
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
        HomeBannerBean homeBannerBean = new Gson().fromJson(s, HomeBannerBean.class);
        adapter.setBanner1(homeBannerBean.getResult());
    }

    @Override
    public void Cuow1(String s) {
        Toast.makeText(getActivity(),s,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void xsuccess(String s) {
        Category1 category1 = new Gson().fromJson(s, Category1.class);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        ((LinearLayoutManager) layoutManager).setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView2.setLayoutManager(layoutManager);
        adapterca = new CategoryAdapter(getActivity(),category1.getResult());
        recyclerView2.setAdapter(adapterca);
        adapterca.setOnRecyclerViewItemClickListener(new CategoryAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position, String id) {
                Toast.makeText(getActivity(),"您点击了第"+id+"条信息",Toast.LENGTH_SHORT).show();
                HashMap<String,String> hashMap = new HashMap<>();
                hashMap.put("firstCategoryId",id);
                persenter2.getData(hashMap);
            }

            @Override
            public void onLongClick(int position) {
                Toast.makeText(getActivity(),"您点击了第"+position+"条信息",Toast.LENGTH_SHORT).show();
            }
        });
        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("firstCategoryId","1001002");
        persenter2.getData(hashMap);
    }

    @Override
    public void xcuowu(String s) {
        Toast.makeText(getActivity(),s,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void xsuccess2(String s) {
        Category1 category1 = new Gson().fromJson(s, Category1.class);
        CategoryAdapter2 adapter2 = new CategoryAdapter2(getActivity(),category1.getResult());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        ((LinearLayoutManager) layoutManager).setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView3.setLayoutManager(layoutManager);
        recyclerView3.setAdapter(adapter2);
        adapter2.setOnRecyclerViewItemClickListener2(new CategoryAdapter2.OnItemClickListener() {
            @Override
            public void onClick(int position, String id) {
                Intent intent = new Intent(getActivity(),HomeListActivity.class);
                intent.putExtra("name2",id);
                startActivity(intent);
            }

            @Override
            public void onLongClick(int position) {

            }
        });
    }

    @Override
    public void xcuowu2(String s) {

    }
}

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
import android.widget.Toast;

import com.google.gson.Gson;
import com.lsz.wd_lsz.R;
import com.lsz.wd_lsz.adapter.quanzi_adapter.QuanziAdapter;
import com.lsz.wd_lsz.entiey.quanzi_entity.QuanBean;
import com.lsz.wd_lsz.mvp.quanzi_mvp.quanzi_contract.Q_Contract;
import com.lsz.wd_lsz.mvp.quanzi_mvp.quanzi_persenter.Q_Persenter;

import java.util.HashMap;

public class QuanZiFragment extends Fragment implements Q_Contract.I_View {

    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.quanzi,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        intiData();
    }

    private void initView(View view) {
        recyclerView = view.findViewById(R.id.x_rec_quan);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    private void intiData() {
        Q_Persenter persenter =new Q_Persenter(this);
        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("page","1");
        hashMap.put("count","10");
        persenter.GetData(hashMap);
    }

    @Override
    public void Success(String s) {
        QuanBean bean  = new Gson().fromJson(s,QuanBean.class);
        QuanziAdapter adapter =new QuanziAdapter(getActivity(),bean.getResult());
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void Fuile(String s) {
        Toast.makeText(getContext(),s,Toast.LENGTH_SHORT).show();
    }
}

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
import android.widget.Toast;

import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.lsz.wd_lsz.R;
import com.lsz.wd_lsz.adapter.gouche_adapter.My_adapter;
import com.lsz.wd_lsz.contract.gouche_contract.GouChe_Contract;
import com.lsz.wd_lsz.entiey.gouche_entity.LBean_G;
import com.lsz.wd_lsz.presenter.gouche_persenter.GouChe_Persenter;

import java.util.HashMap;
import java.util.List;

public class LeiMuFragment extends Fragment implements GouChe_Contract.IG_v {

    private Button button;
    private CheckBox checkBox;
    private XRecyclerView xRecyclerView;
    private GouChe_Persenter persenter;

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
        xRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    private void initData() {
        persenter = new GouChe_Persenter(this);
        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("uid","91");
        persenter.GetData(hashMap);
    }


    @Override
    public void Success(List<LBean_G.Cart> s) {
        My_adapter adapter = new My_adapter(s,getActivity());
        xRecyclerView.setAdapter(adapter);
    }

    @Override
    public void Fuil(String s) {
        Toast.makeText(getContext(),s,Toast.LENGTH_SHORT).show();
    }
}

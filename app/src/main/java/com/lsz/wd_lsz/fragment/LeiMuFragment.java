package com.lsz.wd_lsz.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;

import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.lsz.wd_lsz.R;

public class LeiMuFragment extends Fragment {

    private Button button;
    private CheckBox checkBox;
    private XRecyclerView xRecyclerView;

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


    }
}

package com.lsz.wd_lsz.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.gson.Gson;
import com.lsz.wd_lsz.R;

import java.util.HashMap;

public class ShowYeFragment extends Fragment implements ShouYecontract.IShowYeView {


    private ShouYepresenter shouYepresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.showye,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        shouYepresenter = new ShouYepresenter(this);
        shouYepresenter.setShowYeList(new HashMap<String, String>());
        initView(view);
    }

    private void initView(View view) {

    }

    @Override
    public void onsuccess(String relst) {
        Shouye_List_Bean shouye_list_bean = new Gson().fromJson(relst, Shouye_List_Bean.class);
    }

    @Override
    public void onFail(String msg) {
        ShowToast(msg);
    }

    private void ShowToast(String msg) {
        Toast.makeText(getActivity(),msg,Toast.LENGTH_SHORT).show();
    }
}

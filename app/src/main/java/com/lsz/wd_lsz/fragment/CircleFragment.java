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
import com.lsz.wd_lsz.adapter.circleadapter.CircleAdapter;
import com.lsz.wd_lsz.entiey.circleentity.CircleBean;
import com.lsz.wd_lsz.mvp.circlemvp.dianzan.Q_Contractdian;
import com.lsz.wd_lsz.mvp.circlemvp.dianzan.Q_Persenterdian;
import com.lsz.wd_lsz.mvp.circlemvp.quanz.Q_Contract;
import com.lsz.wd_lsz.mvp.circlemvp.quanz.Q_Persenter;

import java.util.HashMap;

public class CircleFragment extends Fragment implements Q_Contract.I_View,Q_Contractdian.I_Viewdina {

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
        CircleBean bean  = new Gson().fromJson(s,CircleBean.class);
        CircleAdapter adapter =new CircleAdapter(getActivity(),bean.getResult());
        recyclerView.setAdapter(adapter);
        adapter.setmClickListener(new CircleAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, String s, Boolean t) {
                if (t){
                    /*
                    * 点赞
                    * */
                    Q_Persenterdian persenterdian = new Q_Persenterdian(CircleFragment.this);
                    HashMap<String,String> hashMap = new HashMap<>();
                    hashMap.put("commodityId",s);
                    persenterdian.GetData(hashMap);
                }else {
                    /*
                    * 取消点赞
                    * */

                }
            }
        });
    }

    @Override
    public void Fuile(String s) {
        Toast.makeText(getContext(),s,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void Successdian(String s) {
        Dinazan dinazan = new Gson().fromJson(s, Dinazan.class);

    }

    @Override
    public void Fuiledian(String s) {



    }
}

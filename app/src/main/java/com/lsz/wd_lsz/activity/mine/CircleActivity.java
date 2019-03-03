package com.lsz.wd_lsz.activity.mine;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.lsz.wd_lsz.R;
import com.lsz.wd_lsz.adapter.mineadapter.MyCircleAdapter;
import com.lsz.wd_lsz.entiey.circleentity.CircleBean;
import com.lsz.wd_lsz.mvp.minemvp.mycircle.Circle_contract;
import com.lsz.wd_lsz.mvp.minemvp.mycircle.Circle_persenter;

import java.util.HashMap;

public class CircleActivity extends AppCompatActivity implements Circle_contract.m_c_v {

    private RecyclerView mCircleC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle);
        getSupportActionBar().hide();
        initView();
        initData();
    }

    private void initData() {
        Circle_persenter persenter = new Circle_persenter(this);
        HashMap<String,String> hashMap =  new HashMap<>();
        hashMap.put("page","1");
        hashMap.put("count","10");
        persenter.GetData(hashMap);
    }

    private void initView() {
        mCircleC =  findViewById(R.id.circle_c);
    }

    @Override
    public void Success(String s) {
        CircleBean circleBean = new Gson().fromJson(s, CircleBean.class);
        boolean equals = circleBean.getResult().equals("");
        if (equals){
            Toast.makeText(CircleActivity.this,"你没有发布评价啊！",Toast.LENGTH_SHORT).show();
        }else {
            MyCircleAdapter adapter = new MyCircleAdapter(this,circleBean.getResult());
            mCircleC.setLayoutManager(new LinearLayoutManager(this));
            mCircleC.setAdapter(adapter);
        }

    }

    @Override
    public void Fault(String s) {
        Log.i("请求错误的原因",s+"");
    }
}

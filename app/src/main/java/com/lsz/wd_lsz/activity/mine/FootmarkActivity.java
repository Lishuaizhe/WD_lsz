package com.lsz.wd_lsz.activity.mine;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;
import com.lsz.wd_lsz.R;
import com.lsz.wd_lsz.adapter.mineadapter.MyFootAdapter;
import com.lsz.wd_lsz.entiey.mineentity.FootBean;
import com.lsz.wd_lsz.mvp.minemvp.myfoot.FootContract;
import com.lsz.wd_lsz.mvp.minemvp.myfoot.FootPersenter;

import java.util.HashMap;

public class FootmarkActivity extends AppCompatActivity implements FootContract.Foot_v {

    private RecyclerView mFootA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_footmark);
        getSupportActionBar().hide();
        initView();
        initData();
    }


    private void initData() {
        FootPersenter persenter = new FootPersenter(this);
        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("page","1");
        hashMap.put("count","30");
        persenter.GetData(hashMap);
    }

    private void initView() {
        mFootA =  findViewById(R.id.foot_a);
    }

    @Override
    public void Successf(String resut) {
        FootBean footBean = new Gson().fromJson(resut, FootBean.class);
        MyFootAdapter adapter = new MyFootAdapter(this,footBean.getResult());
        mFootA.setLayoutManager(new GridLayoutManager(this,3));
        mFootA.setAdapter(adapter);
    }

    @Override
    public void Fuilef(String msg) {

    }
}

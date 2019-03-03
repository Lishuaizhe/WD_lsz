package com.lsz.wd_lsz.activity.details;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.lsz.wd_lsz.R;
import com.lsz.wd_lsz.adapter.homepageadapter.HomeMLSSAdapter;
import com.lsz.wd_lsz.adapter.homepageadapter.HomeSearchAdapter;
import com.lsz.wd_lsz.entiey.homeentity.HomeListBean;
import com.lsz.wd_lsz.entiey.homeentity.QueryListBean;
import com.lsz.wd_lsz.mvp.homemvp.lookup.ShouyechazhaoContract;
import com.lsz.wd_lsz.mvp.homemvp.lookup.ShouyechazhaoPersenter;
import com.lsz.wd_lsz.mvp.homemvp.homelist.HomeListContract;
import com.lsz.wd_lsz.mvp.homemvp.homelist.HomeListPersenter;

import java.util.HashMap;

public class HomeListActivity extends AppCompatActivity implements View.OnClickListener,HomeListContract.IshouYe_V,ShouyechazhaoContract.IcshouYe_V {
    /**
     * 返回
     */
    private ImageView mFan;
    private EditText mShur;
    private ImageView image_3;
    /**
     * 搜索
     */
    private TextView mSou;
    private RecyclerView mRecyActivity3;
    private String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        getSupportActionBar().hide();
        initView();
        Intent intent = getIntent();
        id = intent.getStringExtra("name");
        String name2 = intent.getStringExtra("name2");
        dianji2(name2);
    }

    private void dianji2(String name2) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("keyword", name2);
        hashMap.put("page", "1");
        hashMap.put("count", "10");
        ShouyechazhaoPersenter shouyechazhaoPersenter = new ShouyechazhaoPersenter(this);
        shouyechazhaoPersenter.getData(hashMap);
    }

    private void initData() {
        HomeListPersenter persenter = new HomeListPersenter(this);
        persenter.getData(new HashMap<String, String>());
    }

    private void TOSI(String s) {
        Toast.makeText(HomeListActivity.this,s+"",Toast.LENGTH_SHORT).show();
    }

    private void initView() {
        mFan =  findViewById(R.id.fan);
        mFan.setOnClickListener(this);
        mShur =  findViewById(R.id.shur);
        mSou =  findViewById(R.id.sou);
        mSou.setOnClickListener(this);
        mRecyActivity3 =  findViewById(R.id.recy_activity3);
        image_3 = findViewById(R.id.image_3);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.fan:
                finish();
                break;
            case R.id.sou:
                dianji();
                break;
        }
    }

    private void dianji() {
        String trim = mShur.getText().toString().trim();
        if (trim.length()!=0) {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("keyword", trim);
            hashMap.put("page", "1");
            hashMap.put("count", "10");
            ShouyechazhaoPersenter shouyechazhaoPersenter = new ShouyechazhaoPersenter(this);
            shouyechazhaoPersenter.getData(hashMap);
        }else {
            TOSI("请输入找的数据");
        }
    }

    @Override
    public void Success(String s) {
        mRecyActivity3.setLayoutManager(new LinearLayoutManager(this));
        HomeListBean homeListBean = new Gson().fromJson(s, HomeListBean.class);
        if (homeListBean.getMessage().equals("")){
            return;
        }else {
            if (id .equals("1")){
                TOSI(id);
                HomeMLSSAdapter adapterA = new HomeMLSSAdapter(this, homeListBean.getResult().getMlss().getCommodityList());
                mRecyActivity3.setLayoutManager(new GridLayoutManager(this,2));
                mRecyActivity3.setAdapter(adapterA);
                return;
            }else if (id.equals("2")){
                TOSI(id);
                HomeMLSSAdapter adapterA = new HomeMLSSAdapter(this, homeListBean.getResult().getMlss().getCommodityList());
                mRecyActivity3.setLayoutManager(new GridLayoutManager(this,2));
                mRecyActivity3.setAdapter(adapterA);
                return;
            }else if (id.equals("3")){
                TOSI(id);
                HomeMLSSAdapter adapterA = new HomeMLSSAdapter(this, homeListBean.getResult().getMlss().getCommodityList());
                mRecyActivity3.setLayoutManager(new GridLayoutManager(this,2));
                mRecyActivity3.setAdapter(adapterA);
                return;
            }else {


            }
        }
    }

    @Override
    public void Cuow(String s) {
        TOSI(s);
    }

    @Override
    public void Successc(String s) {
        QueryListBean queryListBean = new Gson().fromJson(s, QueryListBean.class);
        HomeSearchAdapter adapter = new HomeSearchAdapter(this, queryListBean.getResult());
        mRecyActivity3.setLayoutManager(new GridLayoutManager(this,2));
        mRecyActivity3.setAdapter(adapter);
    }

    @Override
    public void Cuowc(String s) {
        TOSI(s);
    }
}

package com.lsz.wd_lsz.activity.xiangqingye;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.lsz.wd_lsz.R;
import com.lsz.wd_lsz.adapter.shouye_adapter.ShouYeAdapterA;
import com.lsz.wd_lsz.adapter.shouye_adapter.ShouYeAdapterC;
import com.lsz.wd_lsz.adapter.shouye_adapter.ShouYeshousuoAdapter;
import com.lsz.wd_lsz.entiey.shou_ye_entity.Shouye;
import com.lsz.wd_lsz.entiey.shou_ye_entity.Sxiangqing;
import com.lsz.wd_lsz.mvp.shouye_mvp.chazhao.ShouyechazhaoContract;
import com.lsz.wd_lsz.mvp.shouye_mvp.chazhao.ShouyechazhaoPersenter;
import com.lsz.wd_lsz.mvp.shouye_mvp.shouye_contract.ShouyeContract;
import com.lsz.wd_lsz.mvp.shouye_mvp.shouye_persenter.ShouyePersenter;

import java.util.HashMap;

public class Main3Activity extends AppCompatActivity implements View.OnClickListener,ShouyeContract.IshouYe_V,ShouyechazhaoContract.IcshouYe_V {
    /**
     * 返回
     */
    private Button mFan;
    private EditText mShur;
    /**
     * 搜索
     */
    private Button mSou;
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
        initData();
    }
    private void initData() {
        ShouyePersenter persenter = new ShouyePersenter(this);
        persenter.getData(new HashMap<String, String>());
    }

    private void TOSI(String s) {
        Toast.makeText(Main3Activity.this,s+"",Toast.LENGTH_SHORT).show();
    }

    private void initView() {
        mFan =  findViewById(R.id.fan);
        mFan.setOnClickListener(this);
        mShur =  findViewById(R.id.shur);
        mSou =  findViewById(R.id.sou);
        mSou.setOnClickListener(this);
        mRecyActivity3 =  findViewById(R.id.recy_activity3);
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
        Shouye shouye = new Gson().fromJson(s, Shouye.class);
        //获取数据成功
        if (shouye.equals(null)==true){
            TOSI("没有数据");
            return;
        }else {
            if (id .equals("1")){
                TOSI(id);
                ShouYeAdapterC adapterA = new ShouYeAdapterC(this,shouye.getResult().getPzsh().get(0).getCommodityList());
                mRecyActivity3.setLayoutManager(new GridLayoutManager(this,2));
                mRecyActivity3.setAdapter(adapterA);
                return;
            }else if (id.equals("2")){
                TOSI(id);
                ShouYeAdapterC adapterA = new ShouYeAdapterC(this,shouye.getResult().getRxxp().get(0).getCommodityList());
                mRecyActivity3.setLayoutManager(new GridLayoutManager(this,2));
                mRecyActivity3.setAdapter(adapterA);
                return;
            }else if (id.equals("3")){
                TOSI(id);
                ShouYeAdapterC adapterA = new ShouYeAdapterC(this,shouye.getResult().getMlss().get(0).getCommodityList());
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
        Sxiangqing sxiangqing = new Gson().fromJson(s, Sxiangqing.class);
        ShouYeshousuoAdapter adapter = new ShouYeshousuoAdapter(this,sxiangqing.getResult());
        mRecyActivity3.setLayoutManager(new GridLayoutManager(this,2));
        mRecyActivity3.setAdapter(adapter);
    }

    @Override
    public void Cuowc(String s) {
        TOSI(s);
    }
}

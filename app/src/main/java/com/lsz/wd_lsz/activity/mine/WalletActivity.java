package com.lsz.wd_lsz.activity.mine;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.google.gson.Gson;
import com.lsz.wd_lsz.R;
import com.lsz.wd_lsz.adapter.mineadapter.WalletAdapter;
import com.lsz.wd_lsz.entiey.mineentity.Wallet;
import com.lsz.wd_lsz.mvp.minemvp.wallet.WalletContract;
import com.lsz.wd_lsz.mvp.minemvp.wallet.WalletPersenter;

import java.util.HashMap;

public class WalletActivity extends AppCompatActivity implements WalletContract.Wallet_v {

    private TextView mYue;
    private RecyclerView mLiebiao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallet);
        getSupportActionBar().hide();
        initView();
        initData();
    }

    /*
    * 加载数据
    * */
    private void initData() {
        WalletPersenter walletPersenter = new WalletPersenter(this);
        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("count","10");
        hashMap.put("page","1");
        walletPersenter.GetData(hashMap);
    }

    /*
    * 加载视图
    * */
    private void initView() {
        mYue =  findViewById(R.id.yue);
        mLiebiao =  findViewById(R.id.liebiao);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void Success(String resut) {
        boolean equals = resut.equals(null);
        if (equals){

        }else {
            Wallet wallet = new Gson().fromJson(resut, Wallet.class);
            mYue.setText("余额:"+wallet.getResult().getBalance()+"");
            mLiebiao.setLayoutManager(new LinearLayoutManager(this));
            WalletAdapter adapter = new WalletAdapter(this,wallet.getResult().getDetailList());
            mLiebiao.setAdapter(adapter);
        }
    }

    @Override
    public void Fuile(String msg) {
        Log.i("",msg+"");
    }
}

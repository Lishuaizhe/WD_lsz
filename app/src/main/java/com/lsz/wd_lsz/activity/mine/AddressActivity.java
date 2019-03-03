package com.lsz.wd_lsz.activity.mine;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;
import com.lsz.wd_lsz.R;
import com.lsz.wd_lsz.adapter.mineadapter.MyAddressAdapter;
import com.lsz.wd_lsz.entiey.mineentity.Address;
import com.lsz.wd_lsz.mvp.minemvp.address.AddressContract;
import com.lsz.wd_lsz.mvp.minemvp.address.AddressPersenter;

import java.util.HashMap;

/*
 * 我的收获地址
 * */
public class AddressActivity extends AppCompatActivity implements AddressContract.I_address_V, View.OnClickListener {

    private RecyclerView mDizhi;
    /**
     * 增加收货地址
     */
    private Button mZeng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);
        getSupportActionBar().hide();
        initView();
        initData();
    }

    private void initData() {
        AddressPersenter persenter = new AddressPersenter(this);
        persenter.GetData(new HashMap<String, String>());
    }

    private void initView() {
        mDizhi = findViewById(R.id.dizhi);
        mZeng =  findViewById(R.id.zeng);
        mZeng.setOnClickListener(this);
    }

    @Override
    public void Success(String resut) {
        boolean equals = resut.equals(null);
        if (equals) {

        } else {
            Address address = new Gson().fromJson(resut, Address.class);
            MyAddressAdapter addressAdapter = new MyAddressAdapter(this, address.getResult());
            mDizhi.setLayoutManager(new LinearLayoutManager(this));
            mDizhi.setAdapter(addressAdapter);
        }
    }

    @Override
    public void Fuile(String msg) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.zeng:
                xinzeng();
                break;
        }
    }

    /*
    * 添加地址
    * */
    private void xinzeng() {
        Intent intent = new Intent(AddressActivity.this,AddnewAddressActivity.class);
        startActivity(intent);
    }
}

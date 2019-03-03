package com.lsz.wd_lsz.activity.mine;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.lsz.wd_lsz.R;
import com.lsz.wd_lsz.mvp.minemvp.addnewaddress.newaddressContract;
import com.lsz.wd_lsz.mvp.minemvp.addnewaddress.newaddressPersenter;

import java.util.HashMap;

public class AddnewAddressActivity extends AppCompatActivity implements View.OnClickListener,newaddressContract.I_new_V {

    private EditText mShoujian;
    private EditText mPhone;
    private EditText mSuozai;
    private EditText mXiangxi;
    private EditText mBianma;
    /**
     * 保存并使用
     */
    private Button mBaocun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addnew_address);
        getSupportActionBar().hide();
        initView();
        initData();
        mBaocun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name= mShoujian.getText().toString();
                String phone = mPhone.getText().toString();
                String suozai = mSuozai.getText().toString();
                String xianxi = mXiangxi.getText().toString();
                String youzebianma = mBianma.getText().toString();
                if (name!=null&&phone!=null&suozai!=null){
                    HashMap<String,String> hashMap = new HashMap<>();
                    hashMap.put("realName",name);
                    hashMap.put("phone",phone);
                    hashMap.put("address",suozai+xianxi);
                    hashMap.put("zipCode",youzebianma);
                    newaddressPersenter persenter =  new newaddressPersenter(AddnewAddressActivity.this);
                    persenter.GetData(hashMap);
                }

            }
        });
    }


    private void initData() {

    }

    private void initView() {
        mShoujian =  findViewById(R.id.shoujian);
        mPhone =  findViewById(R.id.phone);
        mSuozai =  findViewById(R.id.suozai);
        mXiangxi =  findViewById(R.id.xiangxi);
        mBianma =  findViewById(R.id.bianma);
        mBaocun =  findViewById(R.id.baocun);
        mBaocun.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.baocun:
                break;
        }
    }

    @Override
    public void Success(String resut) {
        Toast.makeText(AddnewAddressActivity.this,resut+"",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void Fuile(String msg) {

    }
}

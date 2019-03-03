package com.lsz.wd_lsz.activity.mine;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.google.gson.Gson;
import com.lsz.wd_lsz.R;
import com.lsz.wd_lsz.entiey.mineentity.Mine;
import com.lsz.wd_lsz.mvp.minemvp.mine.MineContract;
import com.lsz.wd_lsz.mvp.minemvp.mine.MinePersenter;

import java.util.HashMap;

public class DataActivity extends AppCompatActivity implements MineContract.I_v, View.OnClickListener {

    private SimpleDraweeView mImageData;
    private TextView mNicheng;
    private TextView mMima;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        getSupportActionBar().hide();
        initView();
        initData();
    }

    private void initData() {
        MinePersenter persenter = new MinePersenter(this);
        persenter.GetData(new HashMap<String, String>());
    }

    private void initView() {

        mImageData =  findViewById(R.id.image_data);
        mImageData.setOnClickListener(this);
        mNicheng =  findViewById(R.id.nicheng);
        mNicheng.setOnClickListener(this);
        mMima =  findViewById(R.id.mima);
        mMima.setOnClickListener(this);
    }

    @Override
    public void Success(String resut) {
        Mine mine = new Gson().fromJson(resut, Mine.class);
        mNicheng.setText(mine.getResult().getNickName());
        mMima.setText(mine.getResult().getNickName());
        mImageData.setImageURI(mine.getResult().getHeadPic());
    }

    @Override
    public void Fuile(String msg) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.image_data:
                break;
            case R.id.nicheng:
                break;
            case R.id.mima:
                break;
        }
    }
}

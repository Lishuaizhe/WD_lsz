package com.lsz.wd_lsz.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;
import com.google.gson.Gson;
import com.lsz.wd_lsz.R;
import com.lsz.wd_lsz.activity.mine.AddressActivity;
import com.lsz.wd_lsz.activity.mine.CircleActivity;
import com.lsz.wd_lsz.activity.mine.DataActivity;
import com.lsz.wd_lsz.activity.mine.FootmarkActivity;
import com.lsz.wd_lsz.activity.mine.WalletActivity;
import com.lsz.wd_lsz.entiey.mineentity.Mine;
import com.lsz.wd_lsz.mvp.minemvp.mine.MineContract;
import com.lsz.wd_lsz.mvp.minemvp.mine.MinePersenter;

import java.util.HashMap;

public class MineFragment extends Fragment implements MineContract.I_v {


    private SimpleDraweeView mHead;
    /** ad福建省发卡机 */
    private TextView mNameW;
    /** 个人资料 */
    private TextView mData;
    /** 我的圈子 */
    private TextView mCircle;
    /** 我的足迹 */
    private TextView mFootmark;
    /** 我的钱包 */
    private TextView mWallet;
    /** 收货地址 */
    private TextView mAddress;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.wode,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        initData();

        /*
         * 我的圈子
         */
        mCircle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),CircleActivity.class);
                getContext().startActivity(intent);
            }
        });

        /*
        * 我的资料
        * */
        mData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),DataActivity.class);
                getContext().startActivity(intent);
            }
        });

        /*
        * 我的足迹
        * */
        mFootmark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),FootmarkActivity.class);
                getContext().startActivity(intent);
            }
        });

        /*
        * 我的钱包
        * */
        mWallet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),WalletActivity.class);
                getContext().startActivity(intent);
            }
        });

        /*
        * 我的地址
        * */
        mAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),AddressActivity.class);
                getContext().startActivity(intent);
            }
        });
    }

    private void initData() {
        MinePersenter minePersenter = new MinePersenter(this);
        minePersenter.GetData(new HashMap<String, String>());
    }

    private void initView(View view) {
        mHead = view.findViewById(R.id.Head);
        mNameW = view.findViewById(R.id.name_w);
        mData = view.findViewById(R.id.data);
        mCircle = view.findViewById(R.id.circle);
        mFootmark = view.findViewById(R.id.footmark);
        mWallet = view.findViewById(R.id.wallet);
        mAddress = view.findViewById(R.id.address);
    }


    @Override
    public void Success(String resut) {
        Mine mine = new Gson().fromJson(resut, Mine.class);
        mHead.setImageURI(mine.getResult().getHeadPic());
        mNameW.setText(mine.getResult().getNickName());
    }

    @Override
    public void Fuile(String msg) {
        Tost(msg);
    }

    private void Tost(String s) {
        Toast.makeText(getContext(),s+"",Toast.LENGTH_SHORT).show();
    }
}

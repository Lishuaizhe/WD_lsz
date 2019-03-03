package com.lsz.wd_lsz.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.lsz.wd_lsz.R;
import com.lsz.wd_lsz.adapter.orderadapter.OrderAdapter;
import com.lsz.wd_lsz.entiey.orderentity.Order;
import com.lsz.wd_lsz.mvp.order.all.AllOrderContact;
import com.lsz.wd_lsz.mvp.order.all.AllorderPersenter;

import java.util.HashMap;

public class OrderFragment extends Fragment implements View.OnClickListener,AllOrderContact.I_All_V {

    private ImageView mAllOrder;
    private ImageView mPendingpay;
    private ImageView mCollect;
    private ImageView mEvaluate;
    private ImageView mComplete;
    private AllorderPersenter persenter;
    private RecyclerView recyclerView;
    /**
     * 全部订单
     */
    private TextView mAlltext;
    /**
     * 待付款
     */
    private TextView mPeytext;
    /**
     * 待收货
     */
    private TextView mCollecttext;
    /**
     * 待评价
     */
    private TextView mEvaluatetext;
    /**
     * 已完成
     */
    private TextView mCompletetext;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.order,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        initData();
    }

    private void initData() {
        persenter = new AllorderPersenter(this);
        All();
    }

    private void initView(View view) {
        mAllOrder = view.findViewById(R.id.allorder);
        mAllOrder.setOnClickListener(this);
        mPendingpay = view.findViewById(R.id.pendingpay);
        mPendingpay.setOnClickListener(this);
        mCollect = view.findViewById(R.id.collect);
        mCollect.setOnClickListener(this);
        mComplete = view.findViewById(R.id.complete);
        mComplete.setOnClickListener(this);
        mEvaluate = view.findViewById(R.id.evaluate);
        mEvaluate.setOnClickListener(this);
        recyclerView = view.findViewById(R.id.order_list);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.allorder:
                All();
                break;
            case R.id.pendingpay:
                Pay();
                break;
            case R.id.collect:
                Collect();
                break;
            case R.id.complete:
                Complete();
                break;
            case R.id.evaluate:
                Evaluate();
                break;
        }
    }

    /*
    * 待评价
    * */
    private void Evaluate() {
        Tost("待评价");
        HashMap<String ,String> hashMap = new HashMap<>();
        hashMap.put("status","3");
        hashMap.put("page","1");
        hashMap.put("count","10");
        persenter.GetData(hashMap);
    }

    /*
    * 完成订单
    * */
    private void Complete() {
        Tost("已完成");
        HashMap<String ,String> hashMap = new HashMap<>();
        hashMap.put("status","9");
        hashMap.put("page","1");
        hashMap.put("count","10");
        persenter.GetData(hashMap);
    }

    /*
    * 待收货
    * */
    private void Collect() {
        Tost("待收货");
        HashMap<String ,String> hashMap = new HashMap<>();
        hashMap.put("status","2");
        hashMap.put("page","1");
        hashMap.put("count","10");
        persenter.GetData(hashMap);
    }

    /*
    * 待支付
    * */
    private void Pay() {
        Tost("待支付");
        HashMap<String ,String> hashMap = new HashMap<>();
        hashMap.put("status","1");
        hashMap.put("page","1");
        hashMap.put("count","10");
        persenter.GetData(hashMap);
    }

    /*
    * 全部订单
    * */
    private void All() {
        Tost("全部订单");
        HashMap<String ,String> hashMap = new HashMap<>();
        hashMap.put("status","0");
        hashMap.put("page","1");
        hashMap.put("count","10");
        persenter.GetData(hashMap);
    }

    /*
    * 吐司提示
    * */
    private void Tost(String s) {
        Toast.makeText(getContext(),s+"",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void Success(String resut) {
        boolean equals = resut.equals(null);
        if (equals){

        }else {
            Order order = new Gson().fromJson(resut, Order.class);
            OrderAdapter adapter = new OrderAdapter(getActivity(),order.getOrderList());
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            recyclerView.setAdapter(adapter);
        }

    }

    @Override
    public void Fuile(String msg) {
        Tost(msg);
    }
}

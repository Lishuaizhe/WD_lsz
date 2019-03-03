package com.lsz.wd_lsz.adapter.orderadapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lsz.wd_lsz.R;
import com.lsz.wd_lsz.entiey.orderentity.Order;

import java.util.List;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ViewHolder1> {

    private Context context;
    private List<Order.OrderListBean> listBeans;

    public OrderAdapter(Context context, List<Order.OrderListBean> listBeans) {
        this.context = context;
        this.listBeans = listBeans;
    }

    @NonNull
    @Override
    public ViewHolder1 onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.order_size,viewGroup,false);
        return new ViewHolder1(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder1 viewHolder1, int i) {
        Order.OrderListBean orderListBean = listBeans.get(i);
        viewHolder1.dingdanhao.setText("订单号:"+orderListBean.getOrderId()+"");
        viewHolder1.view.setLayoutManager(new LinearLayoutManager(context));
        viewHolder1.view.setAdapter(new OrderAdapter2(context,orderListBean.getDetailList()));
    }

    @Override
    public int getItemCount() {
        return listBeans.size();
    }

    public class ViewHolder1 extends RecyclerView.ViewHolder {

        private final TextView dingdanhao;
        private final RecyclerView view;

        public ViewHolder1(@NonNull View itemView) {
            super(itemView);
            view = itemView.findViewById(R.id.o_recycler);
            dingdanhao = itemView.findViewById(R.id.o_dingdanhao);
        }
    }
}

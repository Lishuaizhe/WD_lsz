package com.lsz.wd_lsz.adapter.orderadapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lsz.wd_lsz.R;
import com.lsz.wd_lsz.entiey.orderentity.Order;

import java.util.List;

public class OrderAdapter2 extends RecyclerView.Adapter<OrderAdapter2.ViewHolder1> {

    private Context context;
    private List<Order.OrderListBean.DetailListBean> listBeans;

    public OrderAdapter2(Context context, List<Order.OrderListBean.DetailListBean> listBeans) {
        this.context = context;
        this.listBeans = listBeans;
    }

    @NonNull
    @Override
    public ViewHolder1 onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.order_size2,viewGroup,false);
        return new ViewHolder1(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder1 viewHolder1, int i) {
        Order.OrderListBean.DetailListBean orderListBean = listBeans.get(i);
        viewHolder1.jage.setText(orderListBean.getCommodityPrice()+"");
        viewHolder1.name.setText(orderListBean.getCommodityName());
        Glide.with(context).load(orderListBean.getCommodityPic()).into(viewHolder1.image);
    }


    @Override
    public int getItemCount() {
        return listBeans.size();
    }

    public class ViewHolder1 extends RecyclerView.ViewHolder {

        private final ImageView image;
        private final TextView jage;
        private final TextView name;
        private final Button pingja;

        public ViewHolder1(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.o_image);
            jage = itemView.findViewById(R.id.o_jiage);
            name = itemView.findViewById(R.id.o_name);
            pingja = itemView.findViewById(R.id.o_pingja);
        }
    }
}

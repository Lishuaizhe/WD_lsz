package com.lsz.wd_lsz.adapter.mineadapter;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.lsz.wd_lsz.R;
import com.lsz.wd_lsz.activity.details.DetailsActivity;
import com.lsz.wd_lsz.entiey.mineentity.Address;
import com.lsz.wd_lsz.entiey.mineentity.FootBean;

import java.util.List;

public class MyAddressAdapter extends XRecyclerView.Adapter<MyAddressAdapter.ViewHolder1> {

    private Context context;

    private List<Address.ResultBean> list;

    public MyAddressAdapter(Context context, List<Address.ResultBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder1 onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.address_size,viewGroup,false);
        return new ViewHolder1(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onBindViewHolder(@NonNull ViewHolder1 viewHolder1, final int i) {
        Address.ResultBean resultBean = list.get(i);
        viewHolder1.textView.setText(resultBean.getRealName());
        viewHolder1.textView1.setText(resultBean.getAddress());
        viewHolder1.textView2.setText(resultBean.getPhone());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder1 extends RecyclerView.ViewHolder {

        private final TextView textView;
        private final TextView textView1;
        private final TextView textView2;

        public ViewHolder1(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textname);
            textView1 = itemView.findViewById(R.id.phone);
            textView2 = itemView.findViewById(R.id.dizhi);
        }
    }
}

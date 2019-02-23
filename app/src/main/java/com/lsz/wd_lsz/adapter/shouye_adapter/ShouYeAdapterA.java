package com.lsz.wd_lsz.adapter.shouye_adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.lsz.wd_lsz.R;
import com.lsz.wd_lsz.activity.xiangqingye.Main4Activity;
import com.lsz.wd_lsz.entiey.shou_ye_entity.Shouye;

import java.util.List;

public class ShouYeAdapterA extends XRecyclerView.Adapter<ShouYeAdapterA.ViewHolder1> {

    private  Context context;

    private List<Shouye.ResultBean.Bean.CommodityListBean> list;

    public ShouYeAdapterA(Context context, List<Shouye.ResultBean.Bean.CommodityListBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder1 onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.shouye_a,viewGroup,false);
        return new ViewHolder1(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder1 viewHolder1, int i) {
        final Shouye.ResultBean.Bean.CommodityListBean commodityListBeanXX = list.get(i);
        viewHolder1.name.setText("  "+commodityListBeanXX.getCommodityName());
        viewHolder1.jia.setText("    ￥:"+commodityListBeanXX.getPrice()+"");
        Glide.with(context).load(commodityListBeanXX.getMasterPic()).into(viewHolder1.imageView);
        viewHolder1.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,Main4Activity.class);
                intent.putExtra("dedeid",commodityListBeanXX.getCommodityId()+"");
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder1 extends RecyclerView.ViewHolder {

        private final ImageView imageView;
        private final TextView jia;
        private final TextView name;

        public ViewHolder1(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.image_a_i);
            jia = itemView.findViewById(R.id.text_a_jia);
            name = itemView.findViewById(R.id.text_a_name);
        }
    }
}

package com.lsz.wd_lsz.adapter.homepageadapter;

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
import com.lsz.wd_lsz.activity.details.DetailsActivity;
import com.lsz.wd_lsz.entiey.homeentity.HomeListBean;

import java.util.List;

public class HomePZSHAdapter extends XRecyclerView.Adapter<HomePZSHAdapter.ViewHolder1> {

    private  Context context;
    private List<HomeListBean.ResultBean.PzshBean.CommodityListBeanX> list;

    public HomePZSHAdapter(Context context, List<HomeListBean.ResultBean.PzshBean.CommodityListBeanX> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder1 onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.homepzsh,viewGroup,false);
        return new ViewHolder1(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder1 viewHolder1, int i) {
        final HomeListBean.ResultBean.PzshBean.CommodityListBeanX commodityListBeanX = list.get(i);

        viewHolder1.name.setText("  "+commodityListBeanX.getCommodityName());
        viewHolder1.jia.setText("    ￥:"+commodityListBeanX.getPrice()+"");
        Glide.with(context).load(commodityListBeanX.getMasterPic()).into(viewHolder1.imageView);
        viewHolder1.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,DetailsActivity.class);
                intent.putExtra("dedeid",commodityListBeanX.getCommodityId()+"");
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

            imageView = itemView.findViewById(R.id.image_pszh);
            jia = itemView.findViewById(R.id.text_pszh2);
            name = itemView.findViewById(R.id.text_pszh1);
        }
    }
}

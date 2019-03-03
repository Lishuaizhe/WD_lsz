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
import com.lsz.wd_lsz.entiey.mineentity.FootBean;

import java.util.List;

public class MyFootAdapter extends XRecyclerView.Adapter<MyFootAdapter.ViewHolder1> {

    private  Context context;

    private List<FootBean.ResultBean> list;

    public MyFootAdapter(Context context, List<FootBean.ResultBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder1 onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.foot_size,viewGroup,false);
        return new ViewHolder1(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onBindViewHolder(@NonNull ViewHolder1 viewHolder1, final int i) {
        final FootBean.ResultBean resultBean = list.get(i);
        Glide.with(context).load(resultBean.getMasterPic()).into(viewHolder1.foot);
        viewHolder1.textView1.setText(resultBean.getCommodityName());
        viewHolder1.textView2.setText(resultBean.getPrice()+"");
        viewHolder1.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,DetailsActivity.class);
                intent.putExtra("dedeid",resultBean.getCommodityId()+"");
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder1 extends RecyclerView.ViewHolder {


        private final ImageView foot;
        private final TextView textView1;
        private final TextView textView2;

        public ViewHolder1(@NonNull View itemView) {
            super(itemView);

            foot = itemView.findViewById(R.id.foot_image);
            textView1 = itemView.findViewById(R.id.foot_text1);
            textView2 = itemView.findViewById(R.id.foot_text1);

        }
    }
}

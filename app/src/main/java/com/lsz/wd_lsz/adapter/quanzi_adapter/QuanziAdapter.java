package com.lsz.wd_lsz.adapter.quanzi_adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.lsz.wd_lsz.R;
import com.lsz.wd_lsz.entiey.quanzi_entity.QuanBean;

import java.util.List;

public class QuanziAdapter extends XRecyclerView.Adapter<QuanziAdapter.ViewHolder1> {

    private  Context context;

    private List<QuanBean.ResultBean> list;

    public QuanziAdapter(Context context, List<QuanBean.ResultBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder1 onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.quanzi_aitem,viewGroup,false);
        return new ViewHolder1(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder1 viewHolder1, int i) {
        QuanBean.ResultBean resultBean = list.get(i);

        viewHolder1.touxiang.setImageURI(resultBean.getHeadPic());
        viewHolder1.tupian.setImageURI(resultBean.getImage());

        viewHolder1.shijian.setText(resultBean.getCreateTime()+"");
        viewHolder1.title.setText(resultBean.getNickName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder1 extends RecyclerView.ViewHolder {

        private final TextView shijian;
        private final SimpleDraweeView touxiang;
        private final SimpleDraweeView tupian;
        private final TextView title;

        public ViewHolder1(@NonNull View itemView) {
            super(itemView);

            shijian = itemView.findViewById(R.id.shijian_q);
            touxiang = itemView.findViewById(R.id.touxiang_q);
            title = itemView.findViewById(R.id.title_q);
            tupian = itemView.findViewById(R.id.tupian_q);

        }
    }
}

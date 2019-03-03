package com.lsz.wd_lsz.adapter.homepageadapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.lsz.wd_lsz.R;
import com.lsz.wd_lsz.entiey.homeentity.Category1;

import java.util.List;

public class CategoryAdapter2 extends XRecyclerView.Adapter<CategoryAdapter2.ViewHolder1> {


    private Context context;

    private List<Category1.ResultBean> list;

    private OnItemClickListener onRecyclerViewItemClickListener;

    public interface OnItemClickListener {
        void onClick(int position, String id);
        void onLongClick(int position);
    }

    public void setOnRecyclerViewItemClickListener2(OnItemClickListener onItemClickListener) {
        this.onRecyclerViewItemClickListener = onItemClickListener;
    }

    public CategoryAdapter2(Context context, List<Category1.ResultBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder1 onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.home_category,viewGroup,false);
        return new ViewHolder1(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder1 viewHolder1, final int i) {
        final Category1.ResultBean commodityListBeanXX = list.get(i);
        viewHolder1.textView.setText(commodityListBeanXX.getName());
        viewHolder1.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onRecyclerViewItemClickListener.onClick(i,commodityListBeanXX.getName());
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder1 extends RecyclerView.ViewHolder {

        private final TextView textView;

        public ViewHolder1(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.biaoti);
        }
    }
}

package com.lsz.wd_lsz.adapter.shoppingadapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.lsz.wd_lsz.R;
import com.lsz.wd_lsz.entiey.shoppingentity.ShoppingCatr;
import com.lsz.wd_lsz.user.view.G_My_View;

import java.util.List;

public class ShoppingCartadapter extends XRecyclerView.Adapter<ShoppingCartadapter.ViewHolder1> {

    private List<ShoppingCatr.ResultBean> list;
    private Context context;

    public ShoppingCartadapter(List<ShoppingCatr.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder1 onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view =LayoutInflater.from(context).inflate(R.layout.shopping_size,viewGroup,false);
        return new ViewHolder1(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder1 viewHolder1, int i) {
        ShoppingCatr.ResultBean resultBean = list.get(i);
        viewHolder1.textView.setText(resultBean.getCommodityName());
        viewHolder1.textView2.setText(resultBean.getPrice()+"");
        Glide.with(context).load(resultBean.pic).into(viewHolder1.imageView);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    class ViewHolder1 extends XRecyclerView.ViewHolder{

        private CheckBox checkBox;
        private TextView textView;
        private TextView textView2;
        private final ImageView imageView;
        private final G_My_View g_my_view;


        public ViewHolder1(@NonNull View itemView) {
            super(itemView);
            checkBox=itemView.findViewById(R.id.g_check_box);
            textView=itemView.findViewById(R.id.g_text);
            imageView = itemView.findViewById(R.id.tupian);
            textView2=itemView.findViewById(R.id.g_text2);
            g_my_view = itemView.findViewById(R.id.myview);
        }
    }

}

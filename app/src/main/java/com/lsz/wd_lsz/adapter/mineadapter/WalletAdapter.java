package com.lsz.wd_lsz.adapter.mineadapter;

import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.lsz.wd_lsz.R;
import com.lsz.wd_lsz.entiey.mineentity.Wallet;

import java.util.List;

public class WalletAdapter extends XRecyclerView.Adapter<WalletAdapter.ViewHolder1> {


    private Context context;
    private List<Wallet.ResultBean.DetailListBean> list;

    public WalletAdapter(Context context, List<Wallet.ResultBean.DetailListBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder1 onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.wallet_item,viewGroup,false);
        return new ViewHolder1(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onBindViewHolder(@NonNull ViewHolder1 viewHolder1, int i) {
        Wallet.ResultBean.DetailListBean resultBean = list.get(i);
        viewHolder1.textView.setText(resultBean.getOrderId()+"");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder1 extends RecyclerView.ViewHolder {


        private final TextView textView;

        public ViewHolder1(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.text_2);
        }
    }
}

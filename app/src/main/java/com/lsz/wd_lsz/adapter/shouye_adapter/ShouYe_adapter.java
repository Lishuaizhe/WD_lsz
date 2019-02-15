package com.lsz.wd_lsz.adapter.shouye_adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.lsz.wd_lsz.R;
import com.lsz.wd_lsz.entiey.Shouye;
import com.stx.xhb.xbanner.XBanner;

import java.util.List;

public class ShouYe_adapter extends RecyclerView.Adapter<ShouYe_adapter.IviewHoldr> {

    private List<Shouye.DataBean> list;

    private Context context;

    public ShouYe_adapter(List<Shouye.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public IviewHoldr onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view =LayoutInflater.from(context).inflate(R.layout.s_shoyue_b_x,viewGroup,false);
        return new IviewHoldr(view);
    }

    @Override
    public void onBindViewHolder(@NonNull IviewHoldr iviewHoldr, int i) {
        Shouye.DataBean dataBean = list.get(i);
        Shouye.DataBean.TuijianBean.ListBeanX.BannerBean banner = dataBean.banner;



    }

    //获取item条目数
    @Override
    public int getItemCount() {
        return list.size();
    }

    class IviewHoldr extends XRecyclerView.ViewHolder {
        private final XBanner xbanner;

        public IviewHoldr(@NonNull View itemView) {
            super(itemView);
            xbanner = itemView.findViewById(R.id.shouye_bane);
        }
    }

}

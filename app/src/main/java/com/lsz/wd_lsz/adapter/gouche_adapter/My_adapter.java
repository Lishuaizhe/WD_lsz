package com.lsz.wd_lsz.adapter.gouche_adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.lsz.wd_lsz.R;
import com.lsz.wd_lsz.mvp.callback.CallUiBack;
import com.lsz.wd_lsz.mvp.callback.CallcarBack;
import com.lsz.wd_lsz.entiey.gouche_entity.LBean_G;

import java.util.List;

public class My_adapter extends XRecyclerView.Adapter<My_adapter.Iv_v> implements CallcarBack {

    private List<LBean_G.ResultBean> list;
    private Context context;
    private CallUiBack callUiBack;

    public void setCallUiBack(CallUiBack callUiBack) {
        this.callUiBack = callUiBack;
    }

    public My_adapter(List<LBean_G.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public Iv_v onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view =LayoutInflater.from(context).inflate(R.layout.g_activity,viewGroup,false);
        return new Iv_v(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final Iv_v iv_v, int i) {

        LBean_G.ResultBean resultBean = list.get(i);


        //        final LBean_G.Cart cart = list.get(i);
//        iv_v.checkBox.setChecked(cart.isChecked);
///*
//        for (LBean_G.Cart.Product cart1 : cart.list) {
//            cart1.pos=i;
//        }*/

/*        iv_v.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                cart.isChecked=iv_v.checkBox.isChecked();

                for (LBean_G.Cart.Product product : cart.list) {
                    product.isProductChecked=cart.isChecked;
                }
                notifyDataSetChanged();

                if (callUiBack!=null){
                    callUiBack.ShuaXin();
                }
            }
        });*/


        iv_v.textView.setText(resultBean.getCommodityName());
/*        iv_v.xRecyclerView.setLayoutManager(new LinearLayoutManager(context));
        My_adapter2 adapter2 = new My_adapter2(cart.list,context);
        iv_v.xRecyclerView.setAdapter(adapter2);
        adapter2.setCallcarBack(this);*/

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
/*
    @Override
    public void ShuaXinitem(boolean a, int i) {
        list.get(i).isChecked=a;

        notifyDataSetChanged();

        if (callUiBack!=null){
            callUiBack.ShuaXin();
        }
    }*/

    @Override
    public void ShuaXinitem(boolean a, int i) {

    }

    @Override
    public void ShuaXinSUM() {
        if (callUiBack!=null){
            callUiBack.ShuaXin();
        }
    }

    class Iv_v extends XRecyclerView.ViewHolder{

        private CheckBox checkBox;
        private TextView textView;
      //  private XRecyclerView xRecyclerView;

        public Iv_v(@NonNull View itemView) {
            super(itemView);
            checkBox=itemView.findViewById(R.id.g_check_box);
            textView=itemView.findViewById(R.id.g_text);
     //       xRecyclerView =itemView.findViewById(R.id.g_xr1);
        }
    }

}

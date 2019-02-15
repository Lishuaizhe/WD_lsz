package com.lsz.wd_lsz.adapter.gouche_adapter;

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
import com.lsz.wd_lsz.mvp.callback.CallcarBack;
import com.lsz.wd_lsz.entiey.gouche_entity.LBean_G;
import com.lsz.wd_lsz.view.G_My_View;

import java.util.List;

public class My_adapter2 extends XRecyclerView.Adapter<My_adapter2.Iv_v>{

    private List<LBean_G.Cart.Product> list;
    private Context context;

    private CallcarBack callcarBack;

    public void setCallcarBack(CallcarBack callcarBack) {
        this.callcarBack = callcarBack;
    }

    public My_adapter2(List<LBean_G.Cart.Product> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public Iv_v onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view =LayoutInflater.from(context).inflate(R.layout.g_activity2,viewGroup,false);
        return new Iv_v(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final Iv_v iv_v, int i) {
        final LBean_G.Cart.Product cart = list.get(i);
        iv_v.textView0.setText(cart.title);
        iv_v.textView1.setText("￥:"+cart.price);
        iv_v.checkBox.setChecked(cart.isProductChecked);
        String[] split = cart.images.split("\\|");
        Glide.with(context).load(split[0]).into(iv_v.imageView);

        iv_v.g_my_view.setIg_my_view(new G_My_View.IG_My_View() {
            @Override
            public void IG_My_View(int Sum) {
                cart.productNum=Sum;
                callcarBack.ShuaXinSUM();
            }
        });


        iv_v.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!iv_v.checkBox.isChecked()){
                    cart.isProductChecked=false;

                    if (callcarBack!=null){
                        callcarBack.ShuaXinitem(false,cart.pos);
                    }

                }else {

                    cart.isProductChecked=true;
                    for (LBean_G.Cart.Product p: list) {
                        if (!p.isProductChecked){
                            if (callcarBack!=null){
                                callcarBack.ShuaXinitem(false,cart.pos);
                            }
                            break;
                        }
                        if (callcarBack!=null){
                            callcarBack.ShuaXinitem(true,cart.pos);
                        }
                    }

                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Iv_v extends XRecyclerView.ViewHolder{

        private CheckBox checkBox;
        private TextView textView0;
        private TextView textView1;
        private final ImageView imageView;
        private final G_My_View g_my_view;

        public Iv_v(@NonNull View itemView) {
            super(itemView);
            checkBox=itemView.findViewById(R.id.g_checked);
            textView0=itemView.findViewById(R.id.g_titel);
            textView1=itemView.findViewById(R.id.g_jiage);
            imageView = itemView.findViewById(R.id.g_image);
            g_my_view = itemView.findViewById(R.id.g_zidingyi);
        }
    }

}

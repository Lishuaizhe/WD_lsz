package com.lsz.wd_lsz.adapter.homepageadapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.lsz.wd_lsz.R;
import com.lsz.wd_lsz.activity.details.HomeListActivity;
import com.lsz.wd_lsz.entiey.homeentity.HomeListBean;
import com.lsz.wd_lsz.entiey.homeentity.HomeBannerBean;
import com.stx.xhb.xbanner.XBanner;

import java.util.ArrayList;
import java.util.List;

public class HomePageAdapter extends XRecyclerView.Adapter<XRecyclerView.ViewHolder> {

    private Context context;

    private HomeListBean.ResultBean list;

    private List<HomeBannerBean.ResultBean> banner1;


    public HomePageAdapter(Context context) {
        this.context = context;
        this.list=new HomeListBean.ResultBean();
    }

    public void setList(HomeListBean.ResultBean list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public void setBanner1(List<HomeBannerBean.ResultBean> banner1) {
        this.banner1 = banner1;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public XRecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (getItemViewType(i)==0){
            View view  = LayoutInflater.from(context).inflate(R.layout.home_banner,viewGroup,false);
            return  new viewBannerHolder(view);
        }else if (getItemViewType(i)==1){
            View view  = LayoutInflater.from(context).inflate(R.layout.home_mlss_item,viewGroup,false);
            return  new viewFenleiHolder(view);
        }else if (getItemViewType(i)==2){
            View view  = LayoutInflater.from(context).inflate(R.layout.home_pszh_item,viewGroup,false);
            return  new viewMiaoHolder(view);
        }else{
            View view  = LayoutInflater.from(context).inflate(R.layout.home_rxxp_item,viewGroup,false);
            return  new viewTuiHolder(view);
        }
    }
    @Override
    public void onBindViewHolder(@NonNull XRecyclerView.ViewHolder viewHolder, final int i) {
        if (viewHolder instanceof viewBannerHolder){
            if (banner1!=null){
                final List<String> imgesUrl = new ArrayList<>();
                final List<String> imgesUrl2 = new ArrayList<>();
                for (HomeBannerBean.ResultBean resultBean : banner1) {
                    imgesUrl.add(resultBean.getImageUrl());
                    imgesUrl2.add(resultBean.getTitle());
                }
                ((viewBannerHolder) viewHolder).xBanner.setData(imgesUrl,imgesUrl2);
                ((viewBannerHolder) viewHolder).xBanner.setmAdapter(new XBanner.XBannerAdapter() {
                    @Override
                    public void loadBanner(XBanner banner, Object model, View view, int position) {
                        Glide.with(context).load(imgesUrl.get(position)).into((ImageView) view);
                    }
                });
            }
        }else if (viewHolder instanceof  viewFenleiHolder){
            HomeListBean.ResultBean.MlssBean mlss = list.getMlss();
            if(mlss != null) {
                ((viewFenleiHolder) viewHolder).textView.setText(mlss.getName());
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
                ((LinearLayoutManager) layoutManager).setOrientation(LinearLayoutManager.HORIZONTAL);
                ((viewFenleiHolder) viewHolder).recyclerView.setLayoutManager(layoutManager);
                HomeMLSSAdapter adapter2 = new HomeMLSSAdapter(context, mlss.getCommodityList());
                ((viewFenleiHolder) viewHolder).recyclerView.setAdapter(adapter2);
                ((viewFenleiHolder) viewHolder).textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context,HomeListActivity.class);
                        intent.putExtra("name", 1+"");
                        context.startActivity(intent);
                    }
                });
            }
        }else if (viewHolder instanceof  viewMiaoHolder){
            HomeListBean.ResultBean.PzshBean pzsh = list.getPzsh();
            if (pzsh!=null){
                ((viewMiaoHolder) viewHolder).textView.setText(pzsh.getName());
                ((viewMiaoHolder) viewHolder).recyclerView.setLayoutManager(new LinearLayoutManager(context));
                HomePZSHAdapter adapter3 = new HomePZSHAdapter(context,pzsh.getCommodityList());
                ((viewMiaoHolder) viewHolder).recyclerView.setAdapter(adapter3);
                ((viewMiaoHolder) viewHolder).textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context,HomeListActivity.class);
                        intent.putExtra("name", 2+"");
                        context.startActivity(intent);
                    }
                });
            }
        }else if (viewHolder instanceof  viewTuiHolder){
            HomeListBean.ResultBean.RxxpBean rxxp = list.getRxxp();
            if (rxxp!=null){
               ((viewTuiHolder) viewHolder).textView.setText(rxxp.getName());
               ((viewTuiHolder) viewHolder).recyclerView.setLayoutManager(new GridLayoutManager(context,2));
                HomeRXXPAdapter adapter2 = new HomeRXXPAdapter(context,rxxp.getCommodityList());
               ((viewTuiHolder) viewHolder).recyclerView.setAdapter(adapter2);
               ((viewTuiHolder) viewHolder).textView.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       Intent intent = new Intent(context,HomeListActivity.class);
                       intent.putExtra("name", 3+"");
                       context.startActivity(intent);
                   }
               });
           }
        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    @Override
    public int getItemViewType(int position) {
        if (position==0){
            return 0;
        }else if (position==1){
            return 1;
        }else if (position==2){
            return 2;
        }else {
            return 3;
        }
    }
    /*
    * banner适配器
    * */
    class viewBannerHolder extends XRecyclerView.ViewHolder{
        private final XBanner xBanner;
        public viewBannerHolder(@NonNull View itemView) {
            super(itemView);
            xBanner = itemView.findViewById(R.id.x_banner);
        }
    }
    /*
    * 分类寄存器
    * */
    class viewFenleiHolder extends XRecyclerView.ViewHolder{
        private final RecyclerView recyclerView;
        private final TextView textView;
        public viewFenleiHolder(@NonNull View itemView) {
            super(itemView);
            recyclerView = itemView.findViewById(R.id.recy_a);
            textView = itemView.findViewById(R.id.text_a);
        }
    }
    /*
     * 秒杀寄存器
     * */
    class viewMiaoHolder extends XRecyclerView.ViewHolder{
        private final RecyclerView recyclerView;
        private final TextView textView;
        public viewMiaoHolder(@NonNull View itemView) {
            super(itemView);
            recyclerView = itemView.findViewById(R.id.recy_c);
            textView = itemView.findViewById(R.id.text_b);
        }
    }

    /*
     * 推荐寄存器
     * */
    class viewTuiHolder extends XRecyclerView.ViewHolder{

        private final RecyclerView recyclerView;
        private final TextView textView;

        public viewTuiHolder(@NonNull View itemView) {
            super(itemView);
            recyclerView = itemView.findViewById(R.id.recy_c);
            textView = itemView.findViewById(R.id.text_c);
        }
    }



}

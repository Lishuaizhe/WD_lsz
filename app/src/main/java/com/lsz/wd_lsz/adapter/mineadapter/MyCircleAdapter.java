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

import com.facebook.drawee.view.SimpleDraweeView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.lsz.wd_lsz.R;
import com.lsz.wd_lsz.entiey.circleentity.CircleBean;

import java.util.List;

public class MyCircleAdapter extends XRecyclerView.Adapter<MyCircleAdapter.ViewHolder1> {

    private  Context context;

    private List<CircleBean.ResultBean> list;

    public MyCircleAdapter(Context context, List<CircleBean.ResultBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder1 onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.quanzi_aitem,viewGroup,false);
        return new ViewHolder1(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onBindViewHolder(@NonNull ViewHolder1 viewHolder1, int i) {
        CircleBean.ResultBean resultBean = list.get(i);
            viewHolder1.touxiang.setImageURI(resultBean.getHeadPic());
            viewHolder1.tupian.setImageURI(resultBean.getImage());
////            yyyy-MM-dd HH:mm:ss
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        long lt = new Long(resultBean.getCreateTime());
//        Date date = new Date(lt);
//        String format = simpleDateFormat.format(date);
//        viewHolder1.shijian.setText(format);
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

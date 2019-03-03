package com.lsz.wd_lsz.activity.details;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.lsz.wd_lsz.R;
import com.lsz.wd_lsz.entiey.shoppingentity.AddCart;
import com.lsz.wd_lsz.entiey.shoppingentity.ShoppingCatr;
import com.lsz.wd_lsz.entiey.shoppingentity.CartBean;
import com.lsz.wd_lsz.entiey.homeentity.DetailsBean;
import com.lsz.wd_lsz.mvp.shoppingmvp.GouChe_Contract;
import com.lsz.wd_lsz.mvp.homemvp.addtocart.JiaGouContract;
import com.lsz.wd_lsz.mvp.homemvp.addtocart.JiaGouPersenter;
import com.lsz.wd_lsz.mvp.homemvp.details.DetailsContract;
import com.lsz.wd_lsz.mvp.homemvp.details.DetailsPersenter;
import com.stx.xhb.xbanner.XBanner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DetailsActivity extends AppCompatActivity implements DetailsContract.Ixiangqing_v, View.OnClickListener,JiaGouContract.IcJia_V,GouChe_Contract.IG_v {

    private DetailsPersenter persenter;
    private TextView mNameX;
    /**
     * 返回
     */
    private ImageView mXFan;
    private XBanner mBannerX;
    private WebView mXWebview;
    private TextView mPirceX;
    private TextView mYishouX;
    private TextView mZhongX;
    private ImageButton mBuy;
    private ImageButton mJiagou;
    private DetailsBean xiangqing;
    private String dedeid;
    private int commodityId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        initView();
        initData();
        getSupportActionBar().hide();
        Intent intent = getIntent();
        dedeid = intent.getStringExtra("dedeid");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("commodityId", dedeid);
        persenter.getData(hashMap);
    }

    private void initData() {
        persenter = new DetailsPersenter(this);
        mXWebview.getSettings().setSupportZoom(true);
        mXWebview.getSettings().setBuiltInZoomControls(true);
        mXWebview.getSettings().setUseWideViewPort(true);
    }

    @Override
    public void xsuccess(String s) {
        xiangqing = new Gson().fromJson(s, DetailsBean.class);
        commodityId = xiangqing.getResult().getCommodityId();

        mNameX.setText(xiangqing.getResult().getCategoryName());
        mPirceX.setText("￥ :" + xiangqing.getResult().getPrice() + "");
        mYishouX.setText("销量 : " + xiangqing.getResult().getCommentNum() + "");
        String picture = xiangqing.getResult().getPicture();
        String[] split = picture.split(",");
        final List<String> h = new ArrayList<>();
        for (String s1 : split) {
            h.add(s1);
        }
        mBannerX.setData(h, null);
        mBannerX.setmAdapter(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, Object model, View view, int position) {
                Glide.with(DetailsActivity.this).load(h.get(position)).into((ImageView) view);
            }
        });
        //mXWebview.loadDataWithBaseURL(null, xiangqing.getResult().getDescribe(), "text/html", "utf-8", null);
        WebSettings settings = mXWebview.getSettings();
        settings.setJavaScriptEnabled(true);//支持JS
/*        String js = "<script type=\"text/javascript\">" +
                "var imgs = document.getElementsByTagName('img');" + // 找到img标签
                "for(var i = 0; i<imgs.length; i++){" +  // 逐个改变
                "imgs[i].style.width = '100%';" +  // 宽度改为100%
                "imgs[i].style.height = 'auto';" +
                "}" +
                "</script>";*/
        mXWebview.loadDataWithBaseURL(null, xiangqing.getResult().getDetails(), "text/html", "utf-8", null);
    }

    @Override
    public void xcuowu(String s) {
        Toast.makeText(DetailsActivity.this, s + "", Toast.LENGTH_SHORT).show();
    }

    private void initView() {

        mXFan = findViewById(R.id.x_fan);
        mXFan.setOnClickListener(this);
        mBannerX = findViewById(R.id.banner_x);
        mPirceX = findViewById(R.id.pirce_x);
        mYishouX = findViewById(R.id.yishou_x);
        mNameX = findViewById(R.id.name_x);
        mZhongX = findViewById(R.id.zhong_x);
        mXWebview = findViewById(R.id.x_webview);
        mBuy =  findViewById(R.id.buy);
        mBuy.setOnClickListener(this);
        mJiagou =  findViewById(R.id.jiagou);
        mJiagou.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
                default:
                    break;
                case R.id.x_fan:
                    finish();
                    break;
            case R.id.buy:
                goumai();
                break;
            case R.id.jiagou:
                /*
                * 首先要先查询购物车  判断数据在不在 购物车内 如果在则当前数据加一 如果没在则 加入新的数据
                * */
                tianjiashuju2();
                break;
        }
    }
    /*
    * 加入购物车
    * */
    private void jiarugouwuche() {

        /*
        GouChe_Persenter persenter= new GouChe_Persenter(this);
        persenter.GetData(new HashMap<String, String>());
        */
    }

    private void tianjiashuju2() {
        List<CartBean> list1 = new ArrayList<>();
        CartBean cartBean= new CartBean();
        cartBean.commodityId=commodityId;
        cartBean.count=1;
        list1.add(cartBean);
        String s = new Gson().toJson(list1);
        Map<String,Object> map= new HashMap<>();
        map.put("data",s);
        JiaGouPersenter persenter = new JiaGouPersenter(this);
        persenter.getData(map);
    }

    /*
    * 购买
    * */
    private void goumai() {
        Toast.makeText(DetailsActivity.this,"直接购买",Toast.LENGTH_LONG).show();
    }

    @Override
    public void Success(String s) {
    //    ShoppingCatr shoppingCatr = new Gson().fromJson(s, ShoppingCatr.class);
//        Log.i("======",lBean_g.getMessage());
//        if (lBean_g.getMessage().equals("查询成功")){
//            List<ShopResultBean> list = new ArrayList<>();
//            List<ShoppingCatr.ResultBean> result = lBean_g.getResult();
//            for (ShoppingCatr.ResultBean resultBean : result) {
//                list.add(new ShopResultBean(resultBean.getCommodityId(),resultBean.getCount()));
//            }
            //tianjiashuju(shoppingCatr.getResult());
//        }
    }

    private void tianjiashuju(List<ShoppingCatr.ResultBean> list) {
/*        List<CartBean> list1 = new ArrayList<>();
        if (list!=null&&list.size()>0){
            for (ShoppingCatr.ResultBean shopResultBean : list) {
                CartBean cartBean = new CartBean();
                cartBean.commodityId = String.valueOf(shopResultBean.getCommodityId());
                cartBean.count = String.valueOf(shopResultBean.getCount());
                list1.add(cartBean);
            }
        }
        CartBean cartBean = new CartBean();
        cartBean.commodityId=commodityId+"";
        cartBean.count = "1";*/
//        if (list.size()==0){
//            list.add(new ShopResultBean(Integer.valueOf(dedeid),1));
//        }else {
//            for (int i = 0; i <list.size() ; i++) {
//                if (Integer.valueOf(dedeid)==list.get(i).getCommodityId()){
//                    int count = list.get(i).getCount();
//                    count++;
//                    list.get(i).setCount(count);
//                    break;
//                }else if (i==list.size()-1){
//                    list.add(new ShopResultBean(Integer.valueOf(dedeid),1));
//                    break;
//                }
//            }
//        }
/*        String s = new Gson().toJson(list1);
        Map<String,Object> map= new HashMap<>();
        map.put("data",s);
        JiaGouPersenter persenter = new JiaGouPersenter(this);
        persenter.getData(map);*/
    }

    @Override
    public void Fuil(String s) {
        Toast.makeText(DetailsActivity.this,s+"",Toast.LENGTH_LONG).show();
    }

    @Override
    public void Successjia(String s) {
        AddCart addCart = new Gson().fromJson(s, AddCart.class);
        if (addCart.getMessage().equals("同步成功")){
            Toast.makeText(DetailsActivity.this, addCart.getMessage()+"",Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(DetailsActivity.this, addCart.getMessage()+"",Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void Cuowjia(String s) {
        Toast.makeText(DetailsActivity.this,s+"",Toast.LENGTH_LONG).show();
    }
}

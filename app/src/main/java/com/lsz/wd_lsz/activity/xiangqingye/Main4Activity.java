package com.lsz.wd_lsz.activity.xiangqingye;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.lsz.wd_lsz.R;
import com.lsz.wd_lsz.entiey.shou_ye_entity.Xiangqing;
import com.lsz.wd_lsz.mvp.shouye_mvp.xiangqing.XiangqingC;
import com.lsz.wd_lsz.mvp.shouye_mvp.xiangqing.XiangqingP;
import com.stx.xhb.xbanner.XBanner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main4Activity extends AppCompatActivity implements XiangqingC.Ixiangqing_v, View.OnClickListener {

    private XBanner mImageX;
    private XiangqingP persenter;
    private TextView mNameX;
    /**
     * 返回
     */
    private Button mXFan;
    private XBanner mBannerX;
    private WebView mXWebview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        initView();
        initData();
        getSupportActionBar().hide();
        Intent intent = getIntent();
        String dedeid = intent.getStringExtra("dedeid");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("commodityId", dedeid);
        persenter.getData(hashMap);
    }

    private void initData() {
        persenter = new XiangqingP(this);
        mXWebview.getSettings().setSupportZoom(true);
        mXWebview.getSettings().setBuiltInZoomControls(true);
        mXWebview.getSettings().setUseWideViewPort(true);
    }

    @Override
    public void xsuccess(String s) {
        Xiangqing xiangqing = new Gson().fromJson(s, Xiangqing.class);
        String picture = xiangqing.getResult().getPicture();
        String[] split = picture.split(",");
        final List<String> h = new ArrayList<>();
        for (String s1 : split) {
            h.add(s1);
        }
        mImageX.setData(h, null);
        mImageX.setmAdapter(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, Object model, View view, int position) {
                Glide.with(Main4Activity.this).load(h.get(position)).into((ImageView) view);
            }
        });
        mNameX.setText(xiangqing.getResult().getCategoryName());

    /*    mXWebview.loadDataWithBaseURL(null,xiangqing.getResult().getDescribe(),"text/html","utf-8",null);
*/
   /* String js = "<script type=\"text/javascript\">" +
                "var imgs = document.getElementsByTagName('img');" + // 找到img标签
                "for(var i = 0; i<imgs.length; i++){" +  // 逐个改变
                "imgs[i].style.width = '100%';" +  // 宽度改为100%
                "imgs[i].style.height = 'auto';" +
                "}" +
                "</script>";*/

        mXWebview.loadDataWithBaseURL(null, xiangqing.getResult().getDescribe(),"text/html", "utf-8", null);


    }

    @Override
    public void xcuowu(String s) {
        Toast.makeText(Main4Activity.this, s + "", Toast.LENGTH_SHORT).show();
    }

    private void initView() {
        mImageX = findViewById(R.id.banner_x);
        mNameX = findViewById(R.id.name_x);
        mXFan =  findViewById(R.id.x_fan);
        mXFan.setOnClickListener(this);
        mBannerX =  findViewById(R.id.banner_x);
        mNameX =  findViewById(R.id.name_x);
        mXWebview =  findViewById(R.id.x_webview);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.x_fan:
                finish();
                break;
        }
    }
}

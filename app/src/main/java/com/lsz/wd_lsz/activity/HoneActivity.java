package com.lsz.wd_lsz.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.lsz.wd_lsz.R;
import com.lsz.wd_lsz.adapter.MyPageadapter;

public class HoneActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private TabLayout mTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hone);
        getSupportActionBar().hide();
        //获取资源id
        initView();

        mViewPager.setAdapter(new MyPageadapter(getSupportFragmentManager()));
        mTabLayout.setupWithViewPager(mViewPager);

    }

    private void initView() {
        mViewPager =  findViewById(R.id.view_pager);
        mTabLayout =  findViewById(R.id.tab_layout);
    }
}

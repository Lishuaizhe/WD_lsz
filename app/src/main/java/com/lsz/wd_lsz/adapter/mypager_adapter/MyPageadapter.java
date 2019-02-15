package com.lsz.wd_lsz.adapter.mypager_adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.lsz.wd_lsz.fragment.FenLeiFragment;
import com.lsz.wd_lsz.fragment.LeiMuFragment;
import com.lsz.wd_lsz.fragment.QuanZiFragment;
import com.lsz.wd_lsz.fragment.ShowYeFragment;
import com.lsz.wd_lsz.fragment.WoDeFragment;

public class MyPageadapter extends FragmentPagerAdapter {

    String[] strings = new String[]{"首页","圈子","类目","分类","我的"};

    public MyPageadapter(FragmentManager fm) {
        super(fm);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return strings[position];
    }

    /*
    *     String[] strings = new String[]{"首页","圈子","类目","分类","我的"};
    * */
    @Override
    public Fragment getItem(int i) {
        switch (i){
            case 0:
                return new ShowYeFragment();
            case 1:
                return  new QuanZiFragment();
            case 2:
                return new LeiMuFragment();
            case 3:
                return new FenLeiFragment();
            default:
                return new WoDeFragment();
        }

    }

    @Override
    public int getCount() {
        return strings.length;
    }
}

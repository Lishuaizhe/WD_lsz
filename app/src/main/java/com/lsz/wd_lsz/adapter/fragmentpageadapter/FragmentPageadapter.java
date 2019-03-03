package com.lsz.wd_lsz.adapter.fragmentpageadapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.lsz.wd_lsz.fragment.OrderFragment;
import com.lsz.wd_lsz.fragment.ShoppingCartFragment;
import com.lsz.wd_lsz.fragment.CircleFragment;
import com.lsz.wd_lsz.fragment.HomePageFragment;
import com.lsz.wd_lsz.fragment.MineFragment;

public class FragmentPageadapter extends FragmentPagerAdapter {

    String[] strings = new String[]{"首页","圈子","类目","分类","我的"};

    public FragmentPageadapter(FragmentManager fm) {
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
                return new HomePageFragment();
            case 1:
                return  new CircleFragment();
            case 2:
                return new ShoppingCartFragment();
            case 3:
                return new OrderFragment();
            default:
                return new MineFragment();
        }

    }

    @Override
    public int getCount() {
        return strings.length;
    }
}

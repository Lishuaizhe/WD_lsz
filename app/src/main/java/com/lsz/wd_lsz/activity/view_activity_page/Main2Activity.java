package com.lsz.wd_lsz.activity.view_activity_page;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.lsz.wd_lsz.R;
import com.lsz.wd_lsz.fragment.FenLeiFragment;
import com.lsz.wd_lsz.fragment.LeiMuFragment;
import com.lsz.wd_lsz.fragment.QuanZiFragment;
import com.lsz.wd_lsz.fragment.ShowYeFragment;
import com.lsz.wd_lsz.fragment.WoDeFragment;

public class Main2Activity extends AppCompatActivity {

    private ViewPager viewpager;
    private BottomNavigationView navigation;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    viewpager.setCurrentItem(0);
                    return true;
                case R.id.navigation_dashboard:
                    viewpager.setCurrentItem(1);
                    return true;
                case R.id.navigation_notifications:
                    viewpager.setCurrentItem(2);
                    return true;
                case R.id.navigation_shopp:
                    viewpager.setCurrentItem(3);
                    return true;
                case R.id.navigation_my:
                    viewpager.setCurrentItem(4);
                    return true;
            }
            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getSupportActionBar().hide();

        intiView();

    }

    private void intiView() {
        viewpager = findViewById(R.id.message);
        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        viewpager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                switch (i){
                    case 0:
                        return  new ShowYeFragment();
                    case 1:
                        return  new QuanZiFragment();
                    case 2:
                        return  new LeiMuFragment();
                    case 3:
                        return  new FenLeiFragment();
                    case 4:
                        return  new WoDeFragment();
                }
                return null;
            }

            @Override
            public int getCount() {
                return 5;
            }
        });
        viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                switch (i){
                    case 0:
                        navigation.setSelectedItemId(R.id.navigation_home);
                        break;
                    case 1:
                        navigation.setSelectedItemId(R.id.navigation_dashboard);
                        break;
                    case 2:
                        navigation.setSelectedItemId(R.id.navigation_notifications);
                        break;
                    case 3:
                        navigation.setSelectedItemId(R.id.navigation_shopp);
                        break;
                    case 4:
                        navigation.setSelectedItemId(R.id.navigation_my);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }
}

package com.example.lzw.zhoukao1;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.lzw.zhoukao1.fragment.OneFragment;
import com.example.lzw.zhoukao1.fragment.ThreeFragment;
import com.example.lzw.zhoukao1.fragment.TwoFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager view_vp;
    private TabLayout tablayout;
    private  String [] mData={"首页","分类","我的"};
    private List<Fragment> fragments = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        view_vp=(ViewPager)findViewById(R.id.view_vp);
        tablayout=(TabLayout)findViewById(R.id.tablayout);
        fragments.add(new OneFragment());
        fragments.add(new TwoFragment());
        fragments.add(new ThreeFragment());
        view_vp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return mData[position];
            }
        });
        tablayout.setupWithViewPager(view_vp);
    }
}

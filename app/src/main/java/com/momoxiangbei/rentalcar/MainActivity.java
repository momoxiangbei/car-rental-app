package com.momoxiangbei.rentalcar;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.momoxiangbei.rentalcar.fragment.HomeFragment;
import com.momoxiangbei.rentalcar.fragment.MyFragment;
import com.momoxiangbei.rentalcar.fragment.RetalFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private ArrayList<Fragment> fragmentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initParam();
    }


    private void initView() {
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        
    }

    private void initParam() {
        fragmentList = new ArrayList<Fragment>();

        Fragment homeFragment= new HomeFragment();
        Fragment retalFragment = new RetalFragment();
        Fragment myFragment = new MyFragment();
        fragmentList.add(homeFragment);
        fragmentList.add(retalFragment);
        fragmentList.add(myFragment);

    }


    class MyViewpager extends FragmentPagerAdapter {

        ArrayList<Fragment> mList;
        public MyViewpager(FragmentManager fm,ArrayList<Fragment> list) {
            super(fm);
            mList = list;
        }

        @Override
        public Fragment getItem(int position) {
            return null;
        }

        @Override
        public int getCount() {
            return 0;
        }
    }

}

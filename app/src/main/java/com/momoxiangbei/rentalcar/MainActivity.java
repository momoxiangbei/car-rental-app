package com.momoxiangbei.rentalcar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.momoxiangbei.rentalcar.fragment.HomeFragment;
import com.momoxiangbei.rentalcar.fragment.MyFragment;
import com.momoxiangbei.rentalcar.fragment.RentalFragment;
import com.momoxiangbei.rentalcar.utils.ToastUtil;

import java.util.ArrayList;

public class MainActivity extends BaseActivity {

    private long mExitTime;

    private ViewPager viewPager;
    private ArrayList<Fragment> fragmentList;
    private MyAdapter myAdapter;
    private RadioGroup rg_lab;


    @Override
    public void create(Bundle bundle) {
        setContentView(R.layout.activity_main);
    }

    public static void startActivity(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }



    @Override
    public void initView() {
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        rg_lab = (RadioGroup) findViewById(R.id.rg_lab);

    }

    @Override
    public void initParams() {

        fragmentList = new ArrayList<Fragment>();
        Fragment homeFragment= new HomeFragment();
        Fragment rentalFragment = new RentalFragment();
        Fragment myFragment = new MyFragment();
        fragmentList.add(homeFragment);
        fragmentList.add(rentalFragment);
        fragmentList.add(myFragment);

        myAdapter = new MyAdapter(getSupportFragmentManager(),fragmentList);
        viewPager.setAdapter(myAdapter);
        viewPager.setCurrentItem(0);
        rg_lab.getChildAt(0).setSelected(true);

        rg_lab.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.rb_home) {
                    viewPager.setCurrentItem(0);
                } else if (checkedId == R.id.rb_rental) {
                    viewPager.setCurrentItem(1);
                } else if (checkedId == R.id.rb_my) {
                    viewPager.setCurrentItem(2);
                }
            }
        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                setItemSelector(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    @Override
    public void initListeners() {

    }

    private void setItemSelector(int i) {

        rg_lab.clearCheck();
        rg_lab.getChildAt(0).setSelected(false);
        rg_lab.getChildAt(1).setSelected(false);
        rg_lab.getChildAt(2).setSelected(false);
        rg_lab.getChildAt(i).setSelected(true);
    }

    class MyAdapter extends FragmentPagerAdapter {

        ArrayList<Fragment> mList;
        public MyAdapter(FragmentManager fm,ArrayList<Fragment> list) {
            super(fm);
            mList = list;
        }

        @Override
        public Fragment getItem(int position) {
            return mList.get(position);
        }

        @Override
        public int getCount() {
            return mList.size();
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if ((System.currentTimeMillis() - mExitTime) > 2000) {
                ToastUtil.showToast("亲，再按一次就退出了哦！");
                mExitTime = System.currentTimeMillis();

            } else {
                finish();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}

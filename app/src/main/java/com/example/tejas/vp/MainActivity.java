package com.example.tejas.vp;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ViewPager mviewPager;
    private TabLayout mtablayout;
    private FruitAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mviewPager =findViewById(R.id.viewPager);
        mAdapter = new FruitAdapter(getSupportFragmentManager());
        mAdapter.addFruit("apple");
        mAdapter.addFruit("Orange");
        mviewPager.setAdapter(mAdapter);


        mtablayout = findViewById(R.id.tablayout);
        mtablayout.setupWithViewPager(mviewPager);
    }

    private class FruitAdapter extends FragmentStatePagerAdapter {

        ArrayList<String> mFruits;
        ArrayList<Fragment> mFragments;
        public FruitAdapter(FragmentManager fm) {
            super(fm);
            mFruits = new ArrayList<>();
            mFragments = new ArrayList<>();
        }

        @Override
        public Fragment getItem(int position) {

            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFruits.size();
        }

        public void addFruit(String fruit){
            mFruits.add(fruit);
            mFragments.add(fruitFragment.newInstance(fruit));
        }

        @Override
        public CharSequence getPageTitle(int position) {

            return mFruits.get(position);
        }
    }

}

package com.example.nestedtab.nestedtab;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainTabs extends FragmentActivity {

    NonScrollableVP mainPager;
    TabLayout tabs;
    Toolbar tb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_tab_layout);
        mainPager = (NonScrollableVP)
                findViewById(R.id.pagerMain);
        tabs = (TabLayout) findViewById(R.id.tabs);
        setUpPager();
    }

    private void setUpPager() {

        MainNewsList news = new MainNewsList();
        MainExtraList extraList = new MainExtraList();
        MainPager adapter = new MainPager(getSupportFragmentManager());
        adapter.addFragment(news, "NEWS");
        adapter.addFragment(extraList, "EXTRA");

        mainPager.setAdapter(adapter);
        tabs.setupWithViewPager(mainPager);

    }

    private class MainPager extends FragmentPagerAdapter {

        List<Fragment> mFragments = new ArrayList<>();
        List<String> mFragmentsTitle = new ArrayList<>();

        public MainPager(FragmentManager fm) {
            super(fm);
        }

        public void addFragment(Fragment f, String s) {
            mFragments.add(f);
            mFragmentsTitle.add(s);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            Log.d("mylog", mFragmentsTitle.get(position));
            return mFragmentsTitle.get(position);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }
    }
}
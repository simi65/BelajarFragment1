package com.miss.belajarfragment;

import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabMain;
    ViewPager vpMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabMain = findViewById(R.id.tabMain);
        vpMain  = findViewById(R.id.vpMain);
        setupViewpager(vpMain);
        tabMain.setupWithViewPager(vpMain);


        /*FragmentManager mFragment = getSupportFragmentManager();
        FragmentTransaction mFragmentTrasnsaction = mFragment.beginTransaction();
        Fragmentbuah fragmentBuah = new Fragmentbuah();

        Fragment fragment = mFragment.findFragmentByTag(Fragmentbuah.class.getSimpleName());
        if (!(fragment instanceof Fragmentbuah)){
            mFragmentTrasnsaction.add(R.id.main_frame,fragmentBuah,Fragmentbuah.class.getSimpleName());
            Log.d("MyFlexibleFragment", "Fragment Name :" + Fragmentbuah.class.getSimpleName());
            mFragmentTrasnsaction.commit();
        }*/
    }

    private void setupViewpager(ViewPager viewPager){

viewPagerAdapter adapter = new viewPagerAdapter(getSupportFragmentManager());
adapter.addFrament(new Fragmentbuah(), "HALAMAN BUAH");
adapter.addFrament(new FragmentSayurr(), "HALAMAN SAYUR");
viewPager.setAdapter(adapter);

    }

    class viewPagerAdapter extends FragmentPagerAdapter{

        private final List<Fragment> fragmentsList = new ArrayList<>();
        private final List<String> titleFaragments = new ArrayList<>();

        public viewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            return fragmentsList.get(i);
        }

        @Override
        public int getCount() {
            return fragmentsList.size();
        }

        public void addFrament(Fragment fragment, String title){
            fragmentsList.add(fragment);
            titleFaragments.add(title);
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return titleFaragments.get(position);
        }
    }
}

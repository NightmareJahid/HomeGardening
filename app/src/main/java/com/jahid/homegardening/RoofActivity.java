package com.jahid.homegardening;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.jahid.homegardening.databinding.ActivityRoofBinding;

import java.util.ArrayList;

public class RoofActivity extends AppCompatActivity {

    ActivityRoofBinding actRoof;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        actRoof = ActivityRoofBinding.inflate(getLayoutInflater());
        setContentView(actRoof.getRoot());

        actRoof.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



        initFragment();
    }

    public void initFragment() {

        ArrayList<RoofFragment> fragmentsList = new ArrayList<>();

        // creating objects  of fragments......



        RoofFragment fruits = new RoofFragment(AppData.fruitsList);
        RoofFragment flowers = new RoofFragment(AppData.flowersList);
        RoofFragment vegetable = new RoofFragment(AppData.vegeList);
        RoofFragment others = new RoofFragment(AppData.otherList);

        // adding objects to the array list..........

        fragmentsList.add(fruits);
        fragmentsList.add(flowers);
        fragmentsList.add(vegetable);
        fragmentsList.add(others);

        ViewpagerAdapter viewpagerAdapter = new ViewpagerAdapter(getSupportFragmentManager(),fragmentsList);
        actRoof.viewpager.setAdapter(viewpagerAdapter);

        actRoof.viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                actRoof.itemTabs.selectTab(actRoof.itemTabs.getTabAt(position));
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        actRoof.itemTabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                actRoof.viewpager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

}
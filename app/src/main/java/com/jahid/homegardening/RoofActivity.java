package com.jahid.homegardening;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.jahid.homegardening.aderpters.AppData;
import com.jahid.homegardening.aderpters.ItemsModel;
import com.jahid.homegardening.databinding.ActivityRoofBinding;

import java.util.ArrayList;
import java.util.List;

public class RoofActivity extends AppCompatActivity {

    ActivityRoofBinding actRoof;
    RoofFragment activeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        actRoof = ActivityRoofBinding.inflate(getLayoutInflater());
        setContentView(actRoof.getRoot());

        AppData.initData();

        actRoof.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        initFragment();

        actRoof.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                activeFragment.getSearch(newText);
                return true;
            }
        });

    }


    public void initFragment() {

        ArrayList<RoofFragment> fragmentsList = new ArrayList<>();

        // creating objects  of fragments......


        RoofFragment fruits = new RoofFragment(AppData.fruitsList,"fruitsList");
        RoofFragment flowers = new RoofFragment(AppData.flowersList,"flowerList");
        RoofFragment vegetable = new RoofFragment(AppData.vegeList,"vegetable");
        RoofFragment others = new RoofFragment(AppData.otherList,"others");

        activeFragment = fruits;

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
                activeFragment = fragmentsList.get(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        actRoof.itemTabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                actRoof.viewpager.setCurrentItem(tab.getPosition());
                activeFragment = fragmentsList.get(tab.getPosition());
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
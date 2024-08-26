package com.jahid.homegardening.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.jahid.homegardening.RoofFragment;
import com.jahid.homegardening.Data.AppData;
import com.jahid.homegardening.aderpters.ViewpagerAdapter;
import com.jahid.homegardening.databinding.ActivityRoofBinding;

import java.util.ArrayList;

public class RoofActivity extends AppCompatActivity {

    ActivityRoofBinding actRoof;
    RoofFragment activeFragment;

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

        actRoof.btnFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RoofActivity.this, FavoriteActivity.class));
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
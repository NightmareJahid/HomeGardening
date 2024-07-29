package com.jahid.homegardening;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

public class ViewpagerAdapter extends FragmentStatePagerAdapter {

    ArrayList<RoofFragment> fragmentsList = new ArrayList<>();

    public ViewpagerAdapter(@NonNull FragmentManager fm, ArrayList<RoofFragment> fragmentsList) {
        super(fm);
        this.fragmentsList = fragmentsList;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentsList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentsList.size();
    }
}

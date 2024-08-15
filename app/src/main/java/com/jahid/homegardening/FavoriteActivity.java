package com.jahid.homegardening;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.jahid.homegardening.aderpters.AppData;
import com.jahid.homegardening.aderpters.ItemsModel;
import com.jahid.homegardening.aderpters.recyclerViewAdapter;
import com.jahid.homegardening.databinding.ActivityFavoriteBinding;

import java.util.List;

public class FavoriteActivity extends AppCompatActivity {

    ActivityFavoriteBinding actFav;
    RoofFragment favFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        actFav = ActivityFavoriteBinding.inflate(getLayoutInflater());
        setContentView(actFav.getRoot());

        actFav.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        favFragment = new RoofFragment(AppData.favList,"favList");

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.fragmentContainer,favFragment);
        fragmentTransaction.commit();


        actFav.btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!AppData.favList.isEmpty()) {
                    favFragment.setClearButton();
                }
            }
        });


    }

}
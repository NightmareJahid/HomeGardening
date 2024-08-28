package com.jahid.homegardening.Activities;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.jahid.homegardening.R;
import com.jahid.homegardening.RoofFragment;
import com.jahid.homegardening.Data.AppData;
import com.jahid.homegardening.databinding.ActivityFavoriteBinding;

public class FavoriteActivity extends AppCompatActivity {

    ActivityFavoriteBinding actFav;
    RoofFragment favFragment;
    AppData appData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        actFav = ActivityFavoriteBinding.inflate(getLayoutInflater());
        setContentView(actFav.getRoot());
        appData = AppData.getAppData();

        actFav.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        favFragment = new RoofFragment(appData.favList,"favList");

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.fragmentContainer,favFragment);
        fragmentTransaction.commit();


        actFav.btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!appData.favList.isEmpty()) {
                    favFragment.setClearButton();
                }
            }
        });


    }

}
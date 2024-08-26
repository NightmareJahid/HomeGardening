package com.jahid.homegardening.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.jahid.homegardening.UnderConstruction;
import com.jahid.homegardening.Data.AppData;
import com.jahid.homegardening.databinding.DashboardActivityBinding;
import com.shashank.sony.fancytoastlib.FancyToast;

public class DashboardActivity extends AppCompatActivity {



    DashboardActivityBinding binding;
    Intent DASHBOARD_TO_ITEM_DATA;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DashboardActivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        DASHBOARD_TO_ITEM_DATA = new Intent(DashboardActivity.this, BalconyRoomActivity.class);


        binding.btnAboutus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Message","About button is clickd!");
                FancyToast.makeText(DashboardActivity.this,"Developer is sleeping !",FancyToast.LENGTH_SHORT,FancyToast.INFO,false).show();
                startActivity(new Intent(DashboardActivity.this, UnderConstruction.class));
            }
        });
        binding.btnRateus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DashboardActivity.this,UnderConstruction.class));
            }
        });




        //........................................Main Buttons..............................

        binding.btnRooftop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DashboardActivity.this, RoofActivity.class));
            }
        });

        binding.btnRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DASHBOARD_TO_ITEM_DATA.putExtra("buttonName","btnRoom");
                startActivity(DASHBOARD_TO_ITEM_DATA);
            }
        });

        binding.btnBalcony.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DASHBOARD_TO_ITEM_DATA.putExtra("buttonName","btnBalcony");
                startActivity(DASHBOARD_TO_ITEM_DATA);
            }
        });

        //..................................................................................................

        AppData.initArrays();
        Log.d("check",AppData.fruitsList.size()+"");

    }
}
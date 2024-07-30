package com.jahid.homegardening;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.jahid.homegardening.aderpters.AppData;
import com.jahid.homegardening.databinding.DashboardActivityBinding;
import com.shashank.sony.fancytoastlib.FancyToast;

public class DashboardActivity extends AppCompatActivity {



    DashboardActivityBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DashboardActivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.btnAboutus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Message","About button is clickd!");
                FancyToast.makeText(DashboardActivity.this,"Developer is sleeping !",FancyToast.LENGTH_SHORT,FancyToast.INFO,false).show();
                startActivity(new Intent(DashboardActivity.this,UnderConstruction.class));
            }
        });
        binding.btnRateus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DashboardActivity.this,UnderConstruction.class));
            }
        });

        binding.btnRooftop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DashboardActivity.this,RoofActivity.class));
            }
        });

        binding.btnRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DashboardActivity.this,UnderConstruction.class));
            }
        });

        binding.btnBalcony.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DashboardActivity.this,UnderConstruction.class));
            }
        });


        AppData.initData();






    }
}
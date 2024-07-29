package com.jahid.homegardening;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.jahid.homegardening.databinding.ActivityUnderConstructionBinding;
import com.shashank.sony.fancytoastlib.FancyToast;

public class UnderConstruction extends AppCompatActivity {

    ActivityUnderConstructionBinding aucBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        aucBinding = ActivityUnderConstructionBinding.inflate(getLayoutInflater());
        setContentView(aucBinding.getRoot());

        aucBinding.backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                FancyToast.makeText(UnderConstruction.this,"Thank you for your patience!",FancyToast.LENGTH_SHORT,FancyToast.INFO,true).show();
            }
        });



    }
}
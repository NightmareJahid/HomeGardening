package com.jahid.homegardening.br;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.jahid.homegardening.R;
import com.jahid.homegardening.RoofFragment;
import com.jahid.homegardening.aderpters.AppData;
import com.jahid.homegardening.aderpters.ItemData;
import com.jahid.homegardening.databinding.ActivityBalconyRoomBinding;

public class BalconyRoomActivity extends AppCompatActivity {

    RoofFragment fragmentList;
    ActivityBalconyRoomBinding actBR;

    String buttonData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        actBR = ActivityBalconyRoomBinding.inflate(getLayoutInflater());
        setContentView(actBR.getRoot());

        AppData.initBalconyRoomData();

        setButtonData();

       initButtonData();

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.fragmentContainer,fragmentList);
        fragmentTransaction.commit();

    }

    private void setButtonData() {
        buttonData = getIntent().getStringExtra("buttonName");
    }

    private void initButtonData() {
        switch (buttonData){
            case "btnRoom": fragmentList = new RoofFragment(AppData.roomList,"roomList");
            break;
            case "btnBalcony": fragmentList = new RoofFragment(AppData.balconyList,"balconyList");
            break;
        }
    }

}
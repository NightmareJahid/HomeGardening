package com.jahid.homegardening.br;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.FragmentTransaction;

import com.jahid.homegardening.FavoriteActivity;
import com.jahid.homegardening.R;
import com.jahid.homegardening.RoofFragment;
import com.jahid.homegardening.aderpters.AppData;
import com.jahid.homegardening.databinding.ActivityBalconyRoomBinding;

public class BalconyRoomActivity extends AppCompatActivity {

    RoofFragment fragmentList;
    ActivityBalconyRoomBinding actBR;

    String buttonData;
    String actName ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        actBR = ActivityBalconyRoomBinding.inflate(getLayoutInflater());
        setContentView(actBR.getRoot());


        AppData.initBalconyRoomData();

        setButtonData();


       initButtonData();

       actBR.btnBack.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               finish();
           }
       });
       actBR.btnFav.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               startActivity(new Intent(BalconyRoomActivity.this, FavoriteActivity.class));
           }
       });


        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.fragmentContainer,fragmentList);
        fragmentTransaction.commit();

        actBR.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                fragmentList.getSearch(newText);
                return true;
            }
        });


    }

    private void setButtonData() {
        buttonData = getIntent().getStringExtra("buttonName");
    }

    private void initButtonData() {
        switch (buttonData){
            case "btnRoom":
                fragmentList = new RoofFragment(AppData.roomList,"roomList");
                actName = "ঘর বাগান";
                Log.d("actName",actName+"");
            break;
            case "btnBalcony":
                fragmentList = new RoofFragment(AppData.balconyList,"balconyList");
                actName = "বারান্দা বাগান";
                Log.d("actName",actName+"");
            break;
        }
    }

}
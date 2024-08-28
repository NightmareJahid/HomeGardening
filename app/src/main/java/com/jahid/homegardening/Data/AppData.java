package com.jahid.homegardening.Data;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class AppData {

    private DatabaseReference reference;

    //............Roof Activity Data......................
    public List<ItemsModel> fruitsList = new ArrayList<>();
    public List<ItemsModel> flowersList = new ArrayList<>();
    public List<ItemsModel> vegeList = new ArrayList<>();
    public List<ItemsModel> otherList = new ArrayList<>();
    //..........Balcony And Room Activity Data.....................
    public List<ItemsModel> balconyList = new ArrayList<>();
    public List<ItemsModel> roomList = new ArrayList<>();
    //...........FavoriteList.....................................
    public List<ItemsModel> favList = new ArrayList<>();
    //....................................................
    private static volatile AppData appData;

    public AppData() {
        initArrays();
    }

    public static AppData getAppData() {
        if (appData == null) {
            appData = new AppData();
        }
        return appData;
    }

    public void initArrays() {
        reference = FirebaseDatabase.getInstance().getReference("ItemData");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot: snapshot.getChildren()) {
                    ItemsModel itemsModel = dataSnapshot.getValue(ItemsModel.class);
                    String category = itemsModel.getCategory();
                    setData(category,itemsModel);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }

    public void initLastItem() {
        reference = FirebaseDatabase.getInstance().getReference("ItemData");
        reference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                ItemsModel itemsModel = snapshot.getValue(ItemsModel.class);
                String category = itemsModel.getCategory();
                setData(category,itemsModel);
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }


    private void setAllArrayEmpty() {
        fruitsList.clear();
        flowersList.clear();
        vegeList.clear();
        otherList.clear();
        roomList.clear();
        balconyList.clear();
    }

    private void setData(String category,ItemsModel itemsModel) {
        switch (category) {
            case "fruit" : fruitsList.add(itemsModel);
                break;
            case "flower" : flowersList.add(itemsModel);
                break;
            case "vegetable" : vegeList.add(itemsModel);
                break;
            case "other" : otherList.add(itemsModel);
                break;
            case "room" : roomList.add(itemsModel);
                break;
            case "balcony" : balconyList.add(itemsModel);
                break;
        }
    }


}

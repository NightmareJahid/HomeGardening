package com.jahid.homegardening.Data;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class AppData {

    private static DatabaseReference reference;

    //............Roof Activity Data......................
    public static List<ItemsModel> fruitsList = new ArrayList<>();
    public static List<ItemsModel> flowersList = new ArrayList<>();
    public static List<ItemsModel> vegeList = new ArrayList<>();
    public static List<ItemsModel> otherList = new ArrayList<>();
    //.................Balcony And Room Activity Data.....................
    public static List<ItemsModel> balconyList = new ArrayList<>();
    public static List<ItemsModel> roomList = new ArrayList<>();
    //..................FavoriteList.....................................
    public static List<ItemsModel> favList = new ArrayList<>();
    //....................................................

    public static void initArrays() {
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

    private static void setData(String category,ItemsModel itemsModel) {
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

package com.jahid.homegardening;

import com.jahid.homegardening.aderpters.ItemsModel;

import java.util.ArrayList;
import java.util.List;

public class AppData {

    public static List<ItemsModel> fruitsList;
    public static List<ItemsModel> flowersList;
    public static List<ItemsModel> vegeList;
    public static List<ItemsModel> otherList;


    public static void initData() {
        ////////////////////////////////////////////////////////////////////////////////////////////
        fruitsList = new ArrayList<>();
        fruitsList.add(new ItemsModel("পেয়ারা","fruits_photo/guava.jpg",""));
        fruitsList.add(new ItemsModel("ড্রাগন","fruits_photo/dragon.jpg",""));
        fruitsList.add(new ItemsModel("জামরুল","fruits_photo/jamrul.jpg",""));
        fruitsList.add(new ItemsModel("লেবু","fruits_photo/lemon.jpg",""));
        fruitsList.add(new ItemsModel("আম","fruits_photo/mango.jpg",""));
        fruitsList.add(new ItemsModel("বড়ই","fruits_photo/plum.jpg",""));
        fruitsList.add(new ItemsModel("ডালিম","fruits_photo/pomegranate.jpg",""));
        fruitsList.add(new ItemsModel("সফেদা","fruits_photo/safeda.jpg",""));
        //////////////////////////////////////////////////////////////////////////////////////////////////

        flowersList = new ArrayList<>();
        vegeList = new ArrayList<>();
        otherList = new ArrayList<>();
    }


}

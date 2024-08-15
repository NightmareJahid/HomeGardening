package com.jahid.homegardening.aderpters;

import com.jahid.homegardening.R;

import java.util.ArrayList;
import java.util.List;

public class AppData {

    //............Roof Activity Data......................
    public static List<ItemsModel> fruitsList;
    public static List<ItemsModel> flowersList;
    public static List<ItemsModel> vegeList;
    public static List<ItemsModel> otherList;
    //....................................................


    //.......balcony and room activity lists.....................
    public static List<ItemsModel> balconyList;
    public static List<ItemsModel> roomList;
    //...........................................................

    public static List<ItemsModel> favList = new ArrayList<>();





    public static void initData() {
        ////////////////////////////////////////////////////////////////////////////////////////////
        fruitsList = new ArrayList<>();
        fruitsList.add(new ItemsModel("পেয়ারা","fruits_photo/guava.jpg",0));
        fruitsList.add(new ItemsModel("ড্রাগন","fruits_photo/dragon.jpg", R.string.dragon_desc));
        fruitsList.add(new ItemsModel("জামরুল","fruits_photo/jamrul.jpg",0));
        fruitsList.add(new ItemsModel("লেবু","fruits_photo/lemon.jpg",0));
        fruitsList.add(new ItemsModel("আম","fruits_photo/mango.jpg",0));
        fruitsList.add(new ItemsModel("বড়ই","fruits_photo/plum.jpg",0));
        fruitsList.add(new ItemsModel("ডালিম","fruits_photo/pomegranate.jpg",0));
        fruitsList.add(new ItemsModel("সফেদা","fruits_photo/safeda.jpg",0));
        //////////////////////////////////////////////////////////////////////////////////////////////////

        flowersList = new ArrayList<>();
        vegeList = new ArrayList<>();
        otherList = new ArrayList<>();


    }

    public static void initBalconyRoomData() {

        balconyList = new ArrayList<>();
        balconyList.add(new ItemsModel("ড্রাগন","fruits_photo/dragon.jpg", R.string.dragon_desc));
        balconyList.add(new ItemsModel("জবা","fruits_photo/mango.jpg",0));
        balconyList.add(new ItemsModel("গোলাপ","fruits_photo/mango.jpg",0));
        balconyList.add(new ItemsModel("আম","fruits_photo/mango.jpg",0));
        balconyList.add(new ItemsModel("আম","fruits_photo/mango.jpg",0));
        balconyList.add(new ItemsModel("আম","fruits_photo/mango.jpg",0));
        balconyList.add(new ItemsModel("আম","fruits_photo/mango.jpg",0));
        balconyList.add(new ItemsModel("আম","fruits_photo/mango.jpg",0));
        balconyList.add(new ItemsModel("আম","fruits_photo/mango.jpg",0));
        balconyList.add(new ItemsModel("আম","fruits_photo/mango.jpg",0));
        balconyList.add(new ItemsModel("আম","fruits_photo/mango.jpg",0));
        balconyList.add(new ItemsModel("আম","fruits_photo/mango.jpg",0));
        balconyList.add(new ItemsModel("আম","fruits_photo/mango.jpg",0));
        balconyList.add(new ItemsModel("আম","fruits_photo/mango.jpg",0));


        roomList = new ArrayList<>();
        roomList.add(new ItemsModel("আম","fruits_photo/mango.jpg",0));
        roomList.add(new ItemsModel("আম","fruits_photo/mango.jpg",0));
        roomList.add(new ItemsModel("আম","fruits_photo/mango.jpg",0));
        roomList.add(new ItemsModel("আম","fruits_photo/mango.jpg",0));
        roomList.add(new ItemsModel("আম","fruits_photo/mango.jpg",0));
        roomList.add(new ItemsModel("আম","fruits_photo/mango.jpg",0));
        roomList.add(new ItemsModel("আম","fruits_photo/mango.jpg",0));
        roomList.add(new ItemsModel("আম","fruits_photo/mango.jpg",0));
        roomList.add(new ItemsModel("আম","fruits_photo/mango.jpg",0));
        roomList.add(new ItemsModel("আম","fruits_photo/mango.jpg",0));


    }




}

package com.jahid.homegardening.Activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.jahid.homegardening.Data.AppData;
import com.jahid.homegardening.Data.ItemsModel;
import com.jahid.homegardening.databinding.ActivityItemDataBinding;

public class ItemData extends AppCompatActivity{

    ActivityItemDataBinding actItemDAta;
    int itemPosition;
    String tag;
    ItemsModel itemsModel;
    String title,photo,intro,description,process;
    AppData appData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        actItemDAta = ActivityItemDataBinding.inflate(getLayoutInflater());
        setContentView(actItemDAta.getRoot());

        initButtonData();
        setList();
        //initAllitems();
        setData();

    }

    private void setData() {

    }

//    private Boolean initAllitems() {
//        title = itemsModel.getTitle();
//        intro = itemsModel.getIntro();
//        description = itemsModel.getDescription();
//        process = itemsModel.getProcess();
//        photo = itemsModel.getImageUrl();
//
//       // if (title.isEmpty() || intro.isEmpty() || description.isEmpty() || process.isEmpty() || )
//    }

    private void setList() {
        switch (tag) {
            case "favList":
                itemsModel = appData.favList.get(itemPosition);
                break;
            case "flowerLists":
                itemsModel = appData.flowersList.get(itemPosition);
                break;
            case "vegetable":
                itemsModel = appData.vegeList.get(itemPosition);
                break;
            case "others":
                itemsModel = appData.otherList.get(itemPosition);
                break;
            case "roomList":
                itemsModel = appData.roomList.get(itemPosition);
                break;
            case "balconyList":
                itemsModel = appData.balconyList.get(itemPosition);
                break;
            default:
                itemsModel = appData.fruitsList.get(itemPosition);
        }
    }

    private void initButtonData() {
        itemPosition = getIntent().getIntExtra("itemPosition", 0);
        tag = getIntent().getStringExtra("tag");
    }
}
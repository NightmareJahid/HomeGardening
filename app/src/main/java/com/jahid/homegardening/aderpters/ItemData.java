package com.jahid.homegardening.aderpters;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Switch;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.jahid.homegardening.R;
import com.jahid.homegardening.databinding.ActivityItemDataBinding;

import java.io.IOException;
import java.io.InputStream;

public class ItemData extends AppCompatActivity {

    ActivityItemDataBinding actItemDAta;
    int itemPosition;
    String tag;
    ItemsModel itemsModel;
    String name;
    int description;
    String photo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        actItemDAta = ActivityItemDataBinding.inflate(getLayoutInflater());
        setContentView(actItemDAta.getRoot());

        initButtonData();
        setList();
        initAllitems();
        setData();

    }

    private void setData() {
        try {
            if (!photo.isBlank()) {

                InputStream inputStream = getAssets().open(photo);
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                actItemDAta.itemImage.setImageBitmap(bitmap);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        actItemDAta.itemName.setText(name);

        if(description != 0 ) actItemDAta.tvDescription.setText(getString(description));

        actItemDAta.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void initAllitems() {
        name = itemsModel.getItemName();
        description = itemsModel.getDescription();
        photo = itemsModel.getItemPhoto();
    }

    private void setList() {
        switch (tag) {
            case "flowerLists":
                itemsModel = AppData.flowersList.get(itemPosition);
                break;
            case "vegetable":
                itemsModel = AppData.vegeList.get(itemPosition);
                break;
            case "others":
                itemsModel = AppData.otherList.get(itemPosition);
                break;
            case "roomList":
                itemsModel = AppData.roomList.get(itemPosition);
                break;
            case "balconyList":
                itemsModel = AppData.balconyList.get(itemPosition);
                break;
            default:
                itemsModel = AppData.fruitsList.get(itemPosition);
        }
    }

    private void initButtonData() {
        itemPosition = getIntent().getIntExtra("itemPosition", 0);
        tag = getIntent().getStringExtra("tag");
    }


}
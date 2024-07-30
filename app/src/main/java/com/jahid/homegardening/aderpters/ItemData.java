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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        actItemDAta = ActivityItemDataBinding.inflate(getLayoutInflater());
        setContentView(actItemDAta.getRoot());

        int itemPosition = getIntent().getIntExtra("itemPosition",0);
        String tag = getIntent().getStringExtra("tag");

        ItemsModel itemData;

        switch (tag) {
            case "fruitsList": itemData = AppData.fruitsList.get(itemPosition);
            break;
            case "flowerList": itemData = AppData.flowersList.get(itemPosition);
            break;
            case "vegetable": itemData = AppData.vegeList.get(itemPosition);
            break;
            case "others":  itemData = AppData.otherList.get(itemPosition);
            break;

            default: itemData = AppData.fruitsList.get(itemPosition);
        }



        String name = itemData.getItemName();

        String photo = itemData.getItemPhoto();

        try {
            InputStream inputStream = this.getAssets().open(photo);
            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
            actItemDAta.itemImage.setImageBitmap(bitmap);
        } catch (IOException e) {
            e.printStackTrace();
        }
       int description = itemData.getDescription();

        if (description != 0) actItemDAta.tvDescription.setText(getString(description));

        actItemDAta.itemName.setText(name);



        actItemDAta.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Log.d("clicked","clicked");
            }
        });

        actItemDAta.itemImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("clicked","clickedImage");
            }
        });

    }
}
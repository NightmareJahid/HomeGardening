package com.jahid.homegardening.aderpters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.jahid.homegardening.R;

import java.io.InputStream;
import java.util.List;


public class recyclerViewAdapter extends RecyclerView.Adapter<recyclerViewAdapter.ViewHolder> {

    private Context context;
    private List<ItemsModel> itemModelList;
    private isClicked isClicked;
    private String tag;

    public recyclerViewAdapter(Context context, List<ItemsModel> itemModelList, recyclerViewAdapter.isClicked isClicked, String tag) {
        this.context = context;
        this.itemModelList = itemModelList;
        this.isClicked = isClicked;
        this.tag = tag;
    }


    public void setFilteredList(List<ItemsModel> filteredList) {
        this.itemModelList = filteredList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public recyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.items_desgin, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull recyclerViewAdapter.ViewHolder holder, int position) {


        initViews(holder, position);


        if (tag.equals("favList")) {
            holder.btnFav.setVisibility(View.GONE);
            holder.btnDel.setVisibility(View.VISIBLE);
            holder.btnDel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    isClicked.getDelClick(holder.getAdapterPosition());
                    notifyDataSetChanged();
                }
            });
        }

//        Animation animation = AnimationUtils.loadAnimation(holder.itemView.getContext(),R.anim.animation);
//        holder.itemView.setAnimation(animation);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isClicked.getItemClick(holder.getAdapterPosition());
            }
        });

        holder.btnFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d("favListSize", AppData.favList.size() + "");

                boolean fabIsClicked = itemModelList.get(holder.getAdapterPosition()).isFav();

                if (!fabIsClicked) {
                    isClicked.getFavClick(holder.getAdapterPosition());
                    holder.btnFav.setColorFilter(ContextCompat.getColor(context, R.color.lime_green), PorterDuff.Mode.SRC_IN);
                    fabIsClicked = !fabIsClicked;
                    Toast.makeText(context, "পছন্দ তালিকায় যুক্ত হয়েছে!", Toast.LENGTH_SHORT).show();
                } else {
                    holder.btnFav.setColorFilter(ContextCompat.getColor(context, R.color.ash), PorterDuff.Mode.SRC_IN);
                    fabIsClicked = !fabIsClicked;
                    AppData.favList.remove(itemModelList.get(holder.getAdapterPosition()));
                    Toast.makeText(context, "পছন্দ তালিকা থেকে সরানো হয়েছে", Toast.LENGTH_SHORT).show();
                }
                itemModelList.get(holder.getAdapterPosition()).setFav(fabIsClicked);
            }
        });

    }


    @Override
    public int getItemCount() {
        return itemModelList.size();
    }


    private void initViews(recyclerViewAdapter.ViewHolder holder, int position) {
        holder.itemName.setText(itemModelList.get(position).getItemName());

        String imgResource = itemModelList.get(position).getItemPhoto();

        try {
            InputStream inputStream = context.getAssets().open(imgResource);
            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
            holder.itemPhoto.setImageBitmap(bitmap);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //........................................................................
    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView itemPhoto, btnFav, btnDel;
        TextView itemName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            itemPhoto = itemView.findViewById(R.id.itemPhoto);
            btnFav = itemView.findViewById(R.id.btnFav);
            itemName = itemView.findViewById(R.id.itemName);
            btnDel = itemView.findViewById(R.id.btnDel);


        }
    }

    ///////////////////////////////////////////////////////////////////////////////////////

    public interface isClicked {
        void getItemClick(int itemPosition);

        void getFavClick(int favPosition);

        void getDelClick(int delPosition);
    }
}

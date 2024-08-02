package com.jahid.homegardening.aderpters;

public class ItemsModel {
    private String itemName;
    private String itemPhoto;
    private  int description;
    private boolean isFav;

    public ItemsModel(String itemName, String itemPhoto, int description, boolean isFav) {
        this.description = description;
        this.itemName = itemName;
        this.itemPhoto = itemPhoto;
        this.isFav = isFav;
    }

    public int getDescription() {
        return description;
    }

    public void setDescription(int description) {
        this.description = description;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemPhoto() {
        return itemPhoto;
    }

    public void setItemPhoto(String itemPhoto) {
        this.itemPhoto = itemPhoto;
    }

    public boolean isFav() {
        return isFav;
    }

    public void setFav(boolean fav) {
        isFav = fav;
    }
}

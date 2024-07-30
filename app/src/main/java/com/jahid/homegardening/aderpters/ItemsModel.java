package com.jahid.homegardening.aderpters;

public class ItemsModel {
    private String itemName;
    private String itemPhoto;
    private  int description;

    public ItemsModel(String itemName, String itemPhoto, int description) {
        this.description = description;
        this.itemName = itemName;
        this.itemPhoto = itemPhoto;
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
}

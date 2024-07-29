package com.jahid.homegardening.aderpters;

public class ItemsModel {
    private String itemName,description;
    private String itemPhoto;

    public ItemsModel(String itemName, String itemPhoto, String description) {
        this.description = description;
        this.itemName = itemName;
        this.itemPhoto = itemPhoto;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
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

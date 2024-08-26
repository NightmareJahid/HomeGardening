package com.jahid.homegardening.Data;

public class ItemsModel {
    String title,intro,description,process,imageUrl,category,tag;

    public ItemsModel() {
    }

    public ItemsModel(String itemName, String itemPhoto, String description, String tag, String process, String intro, String category) {
        this.title = itemName;
        this.imageUrl = itemPhoto;
        this.description = description;
        this.tag = tag;
        this.process = process;
        this.intro = intro;
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}

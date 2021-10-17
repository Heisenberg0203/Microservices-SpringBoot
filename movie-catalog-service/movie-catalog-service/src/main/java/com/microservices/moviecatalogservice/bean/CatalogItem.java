package com.microservices.moviecatalogservice.bean;

public class CatalogItem {

    private String name;
    private String desc;
    private float rating;

    public CatalogItem() {
    }

    public CatalogItem(String name, String desc, float rating) {
        this.name = name;
        this.desc = desc;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
}

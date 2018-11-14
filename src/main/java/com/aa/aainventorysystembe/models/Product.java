package com.aa.aainventorysystembe.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Product {
    @Id
    private String id;

    private String name;
    private String category;
    private int stock;
    private float price;
    private String image;

    //Getter and Setter

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public int getStock() {
        return stock;
    }

    public float getPrice() {
        return price;
    }

    public String getImage() {
        return image;
    }

    public void setId(String _id) {
        this.id = _id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setImage(String image) {
        this.image = image;
    }
}

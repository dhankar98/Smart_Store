package com.example.retail.model;

import java.io.Serializable;

public class ItemModel implements Serializable {
    private String name;
    private String desc;
    private String price;

    public ItemModel(String name, String desc, String price, String discount) {
        this.name = name;
        this.desc = desc;
        this.price = price;
        this.discount = discount;
    }

    private String discount;

    public ItemModel() {

    }


    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

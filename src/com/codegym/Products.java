package com.codegym;

import java.util.Comparator;

public class Products implements Comparator<Products> {
    private int id;
    private String name;
    private long price;
    private String description;

    public Products() {

    }

    public Products(int id, String name, long price, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String toString() {
        return "Products ID: " + this.id + ", Name: " + this.name + ", Price" + this.price + ",Description: " + this.description;
    }

    @Override
    public int compare(Products o1, Products o2) {
        int value = 0;
        if(o1 == null && o2 == null){
            return 0;
        }
        value = o1.getName().compareTo(o2.getName());
        return value;
    }
}

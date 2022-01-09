package com.codegym;

public class Products {
    private int id;
    private String name;
    private double price;
    private String description;

    public Products() {

    }

    public Products(int id, String name, double price, String description) {
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
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

    public int compareTo(Products product) {
        return this.getName().compareTo(product.getName());
    }
}

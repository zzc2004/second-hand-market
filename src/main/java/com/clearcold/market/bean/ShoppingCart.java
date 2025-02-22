package com.clearcold.market.bean;

public class ShoppingCart {
    private int pid;
    private int uid;
    private String name;
    private int quantity;
    private double price;
    private String publisher;
    private String addTime;
    private String image;

    public ShoppingCart() {
    }

    public ShoppingCart(int pid, int uid, String name, int quantity, double price, String publisher, String addTime, String image) {
        this.pid = pid;
        this.uid = uid;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.publisher = publisher;
        this.addTime = addTime;
        this.image = image;
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

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }
}

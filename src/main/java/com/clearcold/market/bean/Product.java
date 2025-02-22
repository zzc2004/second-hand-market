package com.clearcold.market.bean;

public class Product {
    private int id;
    private String name;
    private int quantity;
    private String publisher;
    private String location;
    private double oriPrice;
    private double price;
    private String image;
    private String status;
    private String description;
    private String time;


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    private String type;


    public Product() {
    }

    public Product(int id, String name, int quantity, String location, double oriPrice, double price, String image, String description, String type) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.location = location;
        this.oriPrice = oriPrice;
        this.price = price;
        this.image = image;
        this.description = description;
        this.type = type;
    }

    public Product(String name, int quantity, String publisher, String location, double oriPrice, double price, String image, String status, String description, String time, String type) {
        this.name = name;
        this.quantity = quantity;
        this.publisher = publisher;
        this.location = location;
        this.oriPrice = oriPrice;
        this.price = price;
        this.image = image;
        this.status = status;
        this.description = description;
        this.time = time;
        this.type = type;
    }

    public Product(int id, String name, double oriPrice, double price, int quantity, String publisher, String time, String location, String image, String status, String description, String type) {
        this.id = id;
        this.name = name;
        this.oriPrice = oriPrice;
        this.price = price;
        this.quantity = quantity;
        this.publisher = publisher;
        this.location = location;
        this.image = image;
        this.status = status;
        this.description = description;
        this.time = time;
        this.type = type;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getStatus() {
        return status;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getOriPrice() {
        return oriPrice;
    }

    public void setOriPrice(double oriPrice) {
        this.oriPrice = oriPrice;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

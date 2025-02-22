package com.clearcold.market.bean;

public class Order {
    private int oid;
    private int pid;
    private int uid;
    private int quantity;
    private double price;
    private String time;
    private String status;


    public Order() {
    }

    public Order(int oid, int pid, int uid, int quantity, double price, String time, String status) {
        this.oid = oid;
        this.pid = pid;
        this.uid = uid;
        this.quantity = quantity;
        this.price = price;
        this.time = time;
        this.status = status;
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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

    public void setStatus(String status) {
        this.status = status;
    }
}

package com.clearcold.market.bean;

public class User {
    private int id;
    private String name;
    private String tel;
    private String sex;
    private double balance;
    private String birthday;
    private String email;
    private String signature;
    private String image;
    private String type;


    public User() {
    }

    public User(int id, String name, String tel, String sex, double balance, String birthday, String email, String signature, String image,String type) {
        this.id = id;
        this.name = name;
        this.tel = tel;
        this.sex = sex;
        this.balance = balance;
        this.birthday = birthday;
        this.email = email;
        this.signature = signature;
        this.image = image;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
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

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}

package com.example.lab06jspservletjdbc.beans;

public class Customer {
    private int id;
    private String user;
    private  String pass;
    private String name;
    private String phone;
    private String add;
    private String email;
    private String facebook;
    private String  skyber;
    private Byte status;

    public Customer() {
    }

    public Customer(int id, String user, String pass, String name, String phone, String add, String email, String facebook, String skyber, Byte status) {
        this.id = id;
        this.user = user;
        this.pass = pass;
        this.name = name;
        this.phone = phone;
        this.add = add;
        this.email = email;
        this.facebook = facebook;
        this.skyber = skyber;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getSkyber() {
        return skyber;
    }

    public void setSkyber(String skyber) {
        this.skyber = skyber;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}

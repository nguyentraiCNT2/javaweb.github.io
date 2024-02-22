package com.example.lab06jspservletjdbc.beans;

public class UserAccount {
    private static final String GENDER_MALE = "M";
    private static final String GENDER_FEMALE = "F";

    private String username;
    private String sex;
    private String pass;

    public UserAccount() {
    }

    public UserAccount(String username, String sex, String pass) {
        this.username = username;
        this.sex = sex;
        this.pass = pass;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

}

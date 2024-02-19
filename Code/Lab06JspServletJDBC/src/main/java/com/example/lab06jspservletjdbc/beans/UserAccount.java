package com.example.lab06jspservletjdbc.beans;

public class UserAccount {
    private static final String GENDER_MALE = "M";
    private static final String GENDER_FEMALE = "F";

    private String username;
    private String gender;
    private String password;

    public UserAccount() {
    }

    public UserAccount(String username, String gender, String password) {
        this.username = username;
        this.gender = gender;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

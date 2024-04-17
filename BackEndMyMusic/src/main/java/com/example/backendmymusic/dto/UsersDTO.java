package com.example.backendmymusic.entity;

public class UsersEntity {
    private Integer userID;
    private String userName;
    private String email;
    private String pasword;
    private Integer viewedSongs;
    private UserTypesEntity userTypes;

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasword() {
        return pasword;
    }

    public void setPasword(String pasword) {
        this.pasword = pasword;
    }

    public Integer getViewedSongs() {
        return viewedSongs;
    }

    public void setViewedSongs(Integer viewedSongs) {
        this.viewedSongs = viewedSongs;
    }

    public UserTypesEntity getUserTypes() {
        return userTypes;
    }

    public void setUserTypes(UserTypesEntity userTypes) {
        this.userTypes = userTypes;
    }
}

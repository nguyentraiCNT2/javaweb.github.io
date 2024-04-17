package com.example.backendmymusic.entity;
public class ReviewsEntity {
    private Integer reviewID;
    private UsersEntity userID;
    private  SongsEntity songID;
    private Integer rating;
    private String commet;

    public Integer getReviewID() {
        return reviewID;
    }

    public void setReviewID(Integer reviewID) {
        this.reviewID = reviewID;
    }

    public UsersEntity getUserID() {
        return userID;
    }

    public void setUserID(UsersEntity userID) {
        this.userID = userID;
    }

    public SongsEntity getSongID() {
        return songID;
    }

    public void setSongID(SongsEntity songID) {
        this.songID = songID;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getCommet() {
        return commet;
    }

    public void setCommet(String commet) {
        this.commet = commet;
    }
}

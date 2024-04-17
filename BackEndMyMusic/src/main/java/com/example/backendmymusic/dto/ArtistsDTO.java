package com.example.backendmymusic.entity;

import java.sql.Date;

public class ArtistsEntity {
    private Integer artistID;
    private String name;
    private Date DateOfBirth;
    private String Country;
    private String ImageURL;

    public Integer getArtistID() {
        return artistID;
    }

    public void setArtistID(Integer artistID) {
        this.artistID = artistID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getImageURL() {
        return ImageURL;
    }

    public void setImageURL(String imageURL) {
        ImageURL = imageURL;
    }
}

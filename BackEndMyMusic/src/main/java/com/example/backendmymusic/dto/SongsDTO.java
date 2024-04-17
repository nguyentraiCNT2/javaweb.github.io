package com.example.backendmymusic.entity;

public class SongsEntity {
    private Integer songID;
    private String title;
    private ArtistsEntity artistID;
    private GenresEntity genresID;
    private Integer releaseYear;
    private String audioURL;
    private String imageURL;
private Integer listens;
private Integer download;
private String language;
private String lyrics;
private UsersEntity uploadedBy;
private Boolean Status;

    public Integer getSongID() {
        return songID;
    }

    public void setSongID(Integer songID) {
        this.songID = songID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArtistsEntity getArtistID() {
        return artistID;
    }

    public void setArtistID(ArtistsEntity artistID) {
        this.artistID = artistID;
    }

    public GenresEntity getGenresID() {
        return genresID;
    }

    public void setGenresID(GenresEntity genresID) {
        this.genresID = genresID;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getAudioURL() {
        return audioURL;
    }

    public void setAudioURL(String audioURL) {
        this.audioURL = audioURL;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public Integer getListens() {
        return listens;
    }

    public void setListens(Integer listens) {
        this.listens = listens;
    }

    public Integer getDownload() {
        return download;
    }

    public void setDownload(Integer download) {
        this.download = download;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getLyrics() {
        return lyrics;
    }

    public void setLyrics(String lyrics) {
        this.lyrics = lyrics;
    }

    public UsersEntity getUploadedBy() {
        return uploadedBy;
    }

    public void setUploadedBy(UsersEntity uploadedBy) {
        this.uploadedBy = uploadedBy;
    }

    public Boolean getStatus() {
        return Status;
    }

    public void setStatus(Boolean status) {
        Status = status;
    }
}

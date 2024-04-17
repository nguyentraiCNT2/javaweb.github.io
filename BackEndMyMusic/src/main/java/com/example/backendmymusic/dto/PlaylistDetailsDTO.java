package com.example.backendmymusic.entity;

import org.springframework.data.relational.core.sql.In;

public class PlaylistDetailsEntity {
    private Integer playlistDetailID;
private PlaylistsEntity playlistID;
private SongsEntity songID;

    public Integer getPlaylistDetailID() {
        return playlistDetailID;
    }

    public void setPlaylistDetailID(Integer playlistDetailID) {
        this.playlistDetailID = playlistDetailID;
    }

    public PlaylistsEntity getPlaylistID() {
        return playlistID;
    }

    public void setPlaylistID(PlaylistsEntity playlistID) {
        this.playlistID = playlistID;
    }

    public SongsEntity getSongID() {
        return songID;
    }

    public void setSongID(SongsEntity songID) {
        this.songID = songID;
    }
}

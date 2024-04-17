package com.example.backendmymusic.entity;

import lombok.Getter;

import java.sql.Date;

public class NotificationsEntity {
@Getter
private Integer notificationID;
@Getter
private UsersEntity userID;
@Getter
private SongsEntity songID;
@Getter
private String message;
@Getter
private Date createdAt;
private Boolean  isRead;

    public void setNotificationID(Integer notificationID) {
        this.notificationID = notificationID;
    }

    public void setUserID(UsersEntity userID) {
        this.userID = userID;
    }

    public void setSongID(SongsEntity songID) {
        this.songID = songID;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Boolean getRead() {
        return isRead;
    }

    public void setRead(Boolean read) {
        isRead = read;
    }
}

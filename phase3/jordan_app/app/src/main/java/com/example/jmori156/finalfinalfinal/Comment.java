package com.example.jmori156.finalfinalfinal;

import java.time.LocalDateTime;
import java.util.Date;

public class Comment {
    private int commentId;
    private int eventId;


    private LocalDateTime timePosted;
    private String text;
    private String userName;

    public Comment(String userName, String text, LocalDateTime time)
    {
        this.userName = userName;
        this.text = text;
        this.timePosted = time;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public LocalDateTime getTimePosted() {
        return timePosted;
    }

    public void setTimePosted(LocalDateTime timePosted) {
        this.timePosted = timePosted;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
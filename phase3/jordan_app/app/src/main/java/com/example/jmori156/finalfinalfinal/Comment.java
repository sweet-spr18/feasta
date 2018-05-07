package com.example.jmori156.finalfinalfinal;

import java.time.LocalDateTime;
import java.util.Date;

public class Comment
{
    private String commentText;
    private String userName;
    private Date timeStamp;

    //create constructor
    public Comment(String commentText, String userName, Date timeStamp) {
        this.commentText = commentText;
        this.userName = userName;
        this.timeStamp = timeStamp;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getText()
    {
        return commentText;
    }
    public Date getTime()
    {
        return timeStamp;
    }
}

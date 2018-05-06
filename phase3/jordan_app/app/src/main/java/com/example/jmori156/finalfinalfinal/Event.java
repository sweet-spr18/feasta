package com.example.jmori156.finalfinalfinal;

import java.util.ArrayList;
import java.util.HashSet;

public class Event {
    private int eventId;
    private int locationId;

    private int orgPhoto;
    private String orgName;
    private String eventLocation;
    private String eventTime;
    private int eventPhoto;

    private HashSet<Integer> likes;
    private ArrayList<Comment> comments;

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public int getOrgPhoto() {
        return orgPhoto;
    }

    public void setOrgPhoto(int orgPhoto) {
        this.orgPhoto = orgPhoto;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }

    public String getEventTime() {
        return eventTime;
    }

    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }

    public int getEventPhoto() {
        return eventPhoto;
    }

    public void setEventPhoto(int eventPhoto) {
        this.eventPhoto = eventPhoto;
    }

    public HashSet<Integer> getLikes() {
        return likes;
    }

    public void setLikes(HashSet<Integer> likes) {
        this.likes = likes;
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }
}
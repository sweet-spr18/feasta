package com.example.jmori156.finalfinalfinal;


import java.util.ArrayList;

public class Location {
    private int locationId;

    private int image;
    private String title;

    private ArrayList<Event> events;

//    public Location(int pos){
//        switch(pos) {
//            case 0: setImage(R.drawable.dac);
//                setTitle("DAC");
//                break;
//            case 1: setImage(R.drawable.lib);
//                setTitle("LIB");
//                break;
//            case 2: setImage(R.drawable.sjh);
//                setTitle("SJH");
//                break;
//        }
//    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<Event> getEvents() {
        return events;
    }

    public void setEvents(ArrayList<Event> events) {
        this.events = events;
    }
}
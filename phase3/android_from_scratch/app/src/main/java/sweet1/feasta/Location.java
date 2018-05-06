package sweet1.feasta;

import java.util.ArrayList;

public class Location {
    //private int locationId;

    private int imageResID;
    private String name;

    private ArrayList<Event> events;


    //TODO: drawble references do not work. Might have to convert all the images from jpg to png!
    public Location(String name) {
        switch (name) {
            case "DAC":
                setImageResID(R.drawable.dac);
                break;
            case "MAR":
                setImageResID(R.drawable.mar);
                break;
            case "SJH":
                setImageResID(R.drawable.sjh);
                break;
            case "SUL":
                setImageResID(R.drawable.sul);
                break;
            case "SAH":
                setImageResID(R.drawable.sah);
                break;
            case "LIB":
                setImageResID(R.drawable.lib);
                break;
            case "LAW":
                setImageResID(R.drawable.law);
                break;
            case "BEN":
                setImageResID(R.drawable.ben);
                break;
            case "CAR":
                setImageResID(R.drawable.car);
                break;
            case "CCK":
                setImageResID(R.drawable.cck);
                break;
            case "UC":
                setImageResID(R.drawable.uc);
                break;
            case "Great Lawn":
                setImageResID(R.drawable.great_lawn);
                break;
            case "President's Room":
                setImageResID(R.drawable.presidents_room);
                break;
            case "Ozanam Lounge":
                setImageResID(R.drawable.oz_lounge);
                break;
            case "Adminssions Welcome Ctr":
                setImageResID(R.drawable.adm_welcome);
                break;
        }

    /*public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }*/


    }

    public int getImageResID() {
        return imageResID;
    }

    public void setImageResID(int imageResID) {
        this.imageResID = imageResID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Event> getEvents() {
        return events;
    }

    public void setEvents(ArrayList<Event> events) {
        this.events = events;
    }
}

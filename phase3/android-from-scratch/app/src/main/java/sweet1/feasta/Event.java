package sweet1.feasta;

public class Event {
    private String eventName;
    private String orgName;
    private String location;
    private String time;
    private String foodType;
    private int likesCount;
    /*private Comment[] comments;*/

    public Event(String eventName, String orgName, String location, String time, String foodType, int likesCount) {
        this.eventName = eventName;
        this.orgName = orgName;
        this.location = location;
        this.time = time;
        this.foodType = foodType;
        this.likesCount = likesCount;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    public int getLikesCount() {
        return likesCount;
    }

    public void setLikesCount(int likesCount) {
        this.likesCount = likesCount;
    }

    /*
    public Comment[] getComments() {
        return comments;
    }

    public void setComments(Comment[] comments) {
        this.comments = comments;
    }*/
}

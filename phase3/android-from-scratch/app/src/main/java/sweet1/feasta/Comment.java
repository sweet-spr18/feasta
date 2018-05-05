package sweet1.feasta;

//create class of cardview for recyclerview
public class Comment
{
    private String commentText;
    private String userName;
    private String timeStamp;

    //create constructor
    Comment(String commentText, String userName, String timeStamp) {
        this.commentText = commentText;
        this.userName = userName;
        this.timeStamp = timeStamp;
    }

    //create get method for evert variables
    public String getCommentText() {
        return commentText;
    }

    public String getUserName() {
        return userName;
    }

    public String getTimeStamp() {
        return timeStamp;
    }
}

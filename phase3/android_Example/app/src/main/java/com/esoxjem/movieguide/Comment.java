package com.esoxjem.movieguide;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author arun
 */
public class Comment implements Parcelable
{
    private String id;
    private String author;
    private String content;
    private String url;

    public Comment()
    {

    }

    protected Comment(Parcel in)
    {
        id = in.readString();
        author = in.readString();
        content = in.readString();
        url = in.readString();
    }

    public static final Creator<Comment> CREATOR = new Creator<Comment>()
    {
        @Override
        public Comment createFromParcel(Parcel in)
        {
            return new Comment(in);
        }

        @Override
        public Comment[] newArray(int size)
        {
            return new Comment[size];
        }
    };

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getAuthor()
    {
        return author;
    }

    public void setAuthor(String author)
    {
        this.author = author;
    }

    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

    @Override
    public int describeContents()
    {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(id);
        parcel.writeString(author);
        parcel.writeString(content);
        parcel.writeString(url);
    }
}

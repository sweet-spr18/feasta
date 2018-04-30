package com.esoxjem.movieguide;

import android.os.Parcel;
import android.os.Parcelable;

import com.squareup.moshi.Json;

public class Event implements Parcelable
{
    private String id;
    private String overview;
    @Json(name = "release_date")
    private String releaseDate;
    @Json(name = "poster_path")
    private String posterPath;      //food image
    @Json(name = "backdrop_path")
    private String backdropPath;    //food image
    private String title;
    @Json(name = "likes_count")
    private int likesCount;
    @Json(name = "host")
    private String hostName;
    @Json(name = "building")
    private String buildingName;

    public Event()
    {

    }

    protected Event(Parcel in)
    {
        id = in.readString();
        overview = in.readString();
        releaseDate = in.readString();
        posterPath = in.readString();
        backdropPath = in.readString();
        title = in.readString();
        likesCount = in.readInt();
        hostName = in.readString();
        buildingName = in.readString();
    }

    public static final Creator<Event> CREATOR = new Creator<Event>()
    {
        @Override
        public Event createFromParcel(Parcel in)
        {
            return new Event(in);
        }

        @Override
        public Event[] newArray(int size)
        {
            return new Event[size];
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

    public String getOverview()
    {
        return overview;
    }

    public void setOverview(String overview)
    {
        this.overview = overview;
    }

    public String getReleaseDate()
    {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate)
    {
        this.releaseDate = releaseDate;
    }

    public String getPosterPath()
    {
        return posterPath;
    }

    public void setPosterPath(String posterPath)
    {
        this.posterPath = posterPath;
    }

    public String getBackdropPath()
    {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath)
    {
        this.backdropPath = backdropPath;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public double getLikesCount()
    {
        return likesCount;
    }

    public void setLikesCount(int likesCount)
    {
        this.likesCount = likesCount;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
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
        parcel.writeString(overview);
        parcel.writeString(releaseDate);
        parcel.writeString(posterPath);
        parcel.writeString(backdropPath);
        parcel.writeString(title);
        parcel.writeDouble(likesCount);
    }
}

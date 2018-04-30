package com.esoxjem.movieguide;

import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;

import com.squareup.moshi.Json;

public class Building
{
    /*private String id;
    @Json(name = "poster_path")
    private String posterPath;
    @Json(name = "backdrop_path")
    private String backdropPath;*/
    private String name;
    private int photoID;

    public Building()
    {

    }

    public Building(String name, int photoID) {
        this.name = name;
        this.photoID = photoID;

    }

    /*protected Building(Parcel in)
    {
        id = in.readString();
        *//*posterPath = in.readString();
        backdropPath = in.readString();*//*
        name = "DAC";
    }

    public static final Creator<Building> CREATOR = new Creator<Building>()
    {
        @Override
        public Building createFromParcel(Parcel in)
        {
            return new Building(in);
        }

        @Override
        public Building[] newArray(int size)
        {
            return new Building[size];
        }
    };*/

    /*public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }*/

    /*public String getPosterPath()
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
    }*/

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getPhotoID() {
        return photoID;
    }

    public void setPhotoID(int photoID) {
        this.photoID = photoID;
    }

    /*@Override
    public int describeContents()
    {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(id);
        *//*parcel.writeString(posterPath);
        parcel.writeString(backdropPath);*//*
        parcel.writeString(name);
    }*/
}

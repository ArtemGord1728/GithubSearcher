package com.example.githubsearcher.activity.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Repository implements Parcelable {

    public static final Creator<Repository> CREATOR = new Creator<Repository>() {
        @Override
        public Repository createFromParcel(Parcel in) {
            return new Repository(in);
        }

        @Override
        public Repository[] newArray(int size) {
            return new Repository[size];
        }
    };

    @SerializedName("name")
    @Expose
    private String mName;


    @SerializedName("description")
    @Expose
    private String mDescription;


    @SerializedName("html_url")
    @Expose
    private String mHtmlUrl;

    public Repository() {

    }

    public Repository(String name, String description, String htmlUrl) {
        mName = name;
        mDescription = description;
        mHtmlUrl = htmlUrl;
    }

    protected Repository(Parcel in) {
        mName = in.readString();
        mDescription = in.readString();
        mHtmlUrl = in.readString();
    }

    public String getName() {
        return mName;
    }

    public String getDescription() {
        return mDescription;
    }

    public String getHtmlUrl() {
        return mHtmlUrl;
    }

    public void setDescription(String mDescription) {
        this.mDescription = mDescription;
    }



    public void setHtmlUrl(String mHtmlUrl) {
        this.mHtmlUrl = mHtmlUrl;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mName);
        parcel.writeString(mDescription);
        parcel.writeString(mHtmlUrl);
    }
}

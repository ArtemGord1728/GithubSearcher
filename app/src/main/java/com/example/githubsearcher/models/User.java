package com.example.githubsearcher.activity.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class User implements Parcelable {

    public static final String USER = "user";
    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };


    @SerializedName("id")
    @Expose
    private long id;

    @SerializedName("username")
    @Expose
    private String mLogin;

    @SerializedName("avatar_url")
    @Expose
    private String mAvatar;

    @SerializedName("name")
    @Expose
    private String mName;

    @SerializedName("company")
    @Expose
    private String mCompany;

    @SerializedName("location")
    @Expose
    private String mAddress;

    private List<com.example.githubsearcher.activity.models.Repository> mRepositories;


    public User(String login) {
        this.id = id;
        mLogin = login;
        mAvatar = "";
        mName = "";
        mCompany = "";
        mAddress = "";
        mRepositories = new ArrayList<>();
    }

    public User(Parcel in) {
        mLogin = in.readString();
        mAvatar = in.readString();
        mName = in.readString();
        mCompany = in.readString();
        mAddress = in.readString();
        mRepositories = in.createTypedArrayList(com.example.githubsearcher.activity.models.Repository.CREATOR);
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return mLogin;
    }

    public String getAvatar() {
        return mAvatar;
    }

    public void setAvatar(String avatar) {
        mAvatar = avatar;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public void setCompany(String company) {
        mCompany = company;
    }

    public void setAddress(String address) {
        mAddress = address;
    }

    public String getSecondaryText() {
        String secondaryText = mLogin;
        if (mCompany != null && !mCompany.equals("")) {
            secondaryText += " / " + mCompany;
        }

        if (mAddress != null && !mAddress.equals("")) {
            secondaryText += " / " + mAddress;
        }

        return secondaryText;
    }

    public List<com.example.githubsearcher.activity.models.Repository> getRepositories() {
        return mRepositories;
    }

    public void addRepository(com.example.githubsearcher.activity.models.Repository repo) {
        mRepositories.add(repo);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mLogin);
        parcel.writeString(mAvatar);
        parcel.writeString(mName);
        parcel.writeString(mCompany);
        parcel.writeString(mAddress);
        parcel.writeTypedList(mRepositories);

    }
}

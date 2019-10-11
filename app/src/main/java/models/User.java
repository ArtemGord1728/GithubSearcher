package models;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {

    private long id;
    private String username;
    private int stars;
    private long followers;
    private int packages;
    private long following;

    public User(long id, String username, long followers, long following) {
        this.id = id;
        this.username = username;
        this.followers = followers;
        this.following = following;
    }


    public User(Parcel in) {
        id = in.readLong();
        username = in.readString();
        followers = in.readLong();
        following = in.readLong();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(username);
        dest.writeLong(followers);
        dest.writeLong(following);
    }

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


    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public long getFollowers() {
        return followers;
    }

    public long getFollowing() {
        return following;
    }

    public int getStars() { return stars; }

    public int getPackages() {
        return packages;
    }
}

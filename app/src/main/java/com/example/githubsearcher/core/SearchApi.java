package com.example.githubsearcher.activity.core;

import java.util.List;

import io.reactivex.Single;
import com.example.githubsearcher.activity.models.Repository;
import com.example.githubsearcher.activity.models.User;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface SearchApi {
    @GET("users/{user}")
    Single<User> getUser(@Path("user") String userName);

    @GET("users/{user}/repos")
    Single<List<Repository>> getRepositories(@Path("user") String userName);
}

package com.example.githubsearcher.activity.core;

import java.util.List;

import io.reactivex.Single;
import com.example.githubsearcher.activity.models.Repository;
import com.example.githubsearcher.activity.models.User;

public interface ApiConfig {
    byte CONNECT_TIMEOUT = 120;
    byte WRITE_TIMEOUT = 120;
    byte READ_TIMEOUT = 120;

    boolean noConnection();

    Single<User> getUser(String userName);

    Single<List<Repository>> getRepositories(String userName);
}

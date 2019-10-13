package core.search_core;

import java.util.List;

import io.reactivex.Single;
import models.Repository;
import models.User;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface SearchApi {
    @GET("users/{user}")
    Single<User> getUser(@Path("user") String userName);

    @GET("users/{user}/repos")
    Single<List<Repository>> getRepositories(@Path("user") String userName);
}

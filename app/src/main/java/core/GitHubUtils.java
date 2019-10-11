package core;

import java.util.List;

import models.Repository;
import models.User;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface GitHubUtils
{
    @GET("search/users")
    Call<UserSearchResponse> searchUsers(
            @Query("q") final String query,
            @Query("page") final long page,
            @Query("per_page") final long per_page
    );

    @GET("users/{username}")
    Call<User> getUser(
            @Path("username") final String username);

    Call<List<Repository>> getUserRepos(
            @Path("username") final String username,
            @Query("sort") final String sort,
            @Query("per_page") final long per_page
    );
}

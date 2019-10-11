package core;

import android.database.Observable;

import java.util.List;

import constants.ApiConstants;
import models.Repository;
import models.User;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiConfig {
    private static final long PER_PAGE = 100;
    private static final String REPOS_SORT = "updated";
    private static final long REPOS_PER_PAGE = 8;

    private GitHubUtils gitHubUtils;

    public ApiConfig() {
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(String.valueOf(ApiConstants.GITHUB_HOST))
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        gitHubUtils = retrofit.create(GitHubUtils.class);
    }

    public Call<UserSearchResponse> searchUsers(final String query, final long page) {
        return gitHubUtils.searchUsers(query, page, PER_PAGE);
    }

    public Call<User> getUser(final String username) {
        return gitHubUtils.getUser(username);
    }

    public Call<List<Repository>> getRepo(final String username) {
        return gitHubUtils.getUserRepos(username, REPOS_SORT, REPOS_PER_PAGE);
    }
}

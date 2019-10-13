package com.example.githubsearcher.activity.core.search_core;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.util.List;

import com.example.githubsearcher.activity.core.ApiConfig;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import com.example.githubsearcher.activity.models.Repository;
import com.example.githubsearcher.activity.models.User;

public class NetworkConfig implements ApiConfig {

    private final Context mContext;
    private final SearchApi searchApi;

    public NetworkConfig(Context mContext, SearchApi searchApi) {
        this.mContext = mContext;
        this.searchApi = searchApi;
    }

    @Override
    public boolean noConnection() {
        ConnectivityManager cm = (ConnectivityManager) mContext.getSystemService(
                Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm != null ? cm.getActiveNetworkInfo() : null;

        if (activeNetwork != null){
            if (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI)
                return !activeNetwork.isConnected();
            if (activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE)
                return !activeNetwork.isConnected();
        }

        return true;
    }

    @Override
    public Single<User> getUser(String userName) {
        return searchApi.getUser(userName)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Single<List<Repository>> getRepositories(String userName) {
        return searchApi.getRepositories(userName)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }
}

package com.example.githubsearcher.activity;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.githubsearcher.R;
import com.example.githubsearcher.activity.database.SQLAppTools;


import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


public class FavoritesFragment extends Fragment {

    private Disposable disposable;
    private FavoritesAdapter favoritesAdapter;
    private SQLAppTools sqlAppTools;
    private RecyclerView fragmentFavoritesUserRecycle;

    public FavoritesFragment() { }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        favoritesAdapter = new FavoritesAdapter();
        sqlAppTools = new SQLAppTools(getContext());

        disposable = Observable.fromCallable(sqlAppTools::getAllFavorite)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(favoritesAdapter::addItem);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favorites, container, false);
        fragmentFavoritesUserRecycle = view.findViewById(R.id.fragment_bookmark_users);

        fragmentFavoritesUserRecycle.setLayoutManager(new LinearLayoutManager(getContext()));
        fragmentFavoritesUserRecycle.setAdapter(favoritesAdapter);
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach () {
        super.onDetach();
    }
}

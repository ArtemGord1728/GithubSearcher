package com.example.githubsearcher;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import constants.FavoriteState;
import models.User;


public class UserInfoFragment extends Fragment
{
    private FavoriteState state;
    private MenuItem addUser, removeUser;
    private User user;

    public static UserInfoFragment newInstance(String param1, String param2) {
        UserInfoFragment fragment = new UserInfoFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user_info,
                container,
                false);
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        return view;
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.user_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        return super.onOptionsItemSelected(item);
    }

    private void setUser(User user) {
        this.user = user;
    }

    private void setFavoriteUser(FavoriteState state) {
        this.state = state;
        switch (state) {
            case FAVORITE:
                addUser.setVisible(true);
                removeUser.setVisible(false);
                break;
            case NOT_FAVORITE:
                addUser.setVisible(false);
                removeUser.setVisible(true);
                break;

            default:
                break;
        }
    }
}

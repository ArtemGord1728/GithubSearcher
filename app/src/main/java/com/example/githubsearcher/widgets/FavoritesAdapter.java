package com.example.githubsearcher.widgets;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.githubsearcher.R;
import com.example.githubsearcher.models.User;

import java.util.ArrayList;
import java.util.List;


public class FavoritesAdapter extends RecyclerView.Adapter<FavoritesAdapter.FavoritesViewHolder>{

    private List<User> userList;

    public FavoritesAdapter() {
        userList = new ArrayList<>();
    }

    @NonNull
    @Override
    public FavoritesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        User item = userList.get(0);
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.fragment_favorites, parent, false);
        FavoritesViewHolder favoritesViewHolder = new FavoritesViewHolder(view);

        favoritesViewHolder.searchItemLogin.setText(item.getLogin());

        return favoritesViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FavoritesViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public void addItem(List<User> userList) {
        int start = userList.size();
        this.userList.addAll(userList);
        notifyItemRangeChanged(start, userList.size());
    }

    class FavoritesViewHolder extends RecyclerView.ViewHolder {

        private TextView searchItemLogin;

        public FavoritesViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}

package com.example.githubsearcher.activity.core;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.githubsearcher.R;

import java.util.ArrayList;
import java.util.List;

import com.example.githubsearcher.activity.models.Repository;

public class RepositoriesAdapter extends RecyclerView.Adapter<RepositoryRecycleHolder> implements RepositoryRecycleHolder.ItemClickListener{

    private List<Repository> mRepositories;
    private ItemClickListener mItemClickListener;

    public RepositoriesAdapter(List<Repository> repositories) {
        mRepositories = repositories == null ? new ArrayList<>() : repositories;
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        mItemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public RepositoryRecycleHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RepositoryRecycleHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.repo_info, parent, false));
    }


    @Override
    public void onBindViewHolder(@NonNull RepositoryRecycleHolder holder, int position) {
        Repository repo = mRepositories.get(position);
        holder.setRepository(repo);
        holder.setItemClickListener(this);
    }

    @Override
    public int getItemCount() {
        return mRepositories.size();
    }

    @Override
    public void onItemClick(int position, Repository repository) {
        if (mItemClickListener != null){
            mItemClickListener.onItemClick(position, repository);
        }
    }

    public interface ItemClickListener {
        void onItemClick(int position, Repository repo);
    }

}

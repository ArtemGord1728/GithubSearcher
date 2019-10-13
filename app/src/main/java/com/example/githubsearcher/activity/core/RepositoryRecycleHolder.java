package com.example.githubsearcher.activity.core;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.githubsearcher.R;

import com.example.githubsearcher.activity.models.Repository;

public class RepositoryRecycleHolder extends RecyclerView.ViewHolder {

    private TextView mNameTextView;
    private TextView mDescriptionView;
    private TextView mUrlView;

    private Repository mRepository;
    private ItemClickListener mItemClickListener;

    public RepositoryRecycleHolder(@NonNull View itemView) {
        super(itemView);
        mNameTextView = itemView.findViewById(R.id.name_view);
        mDescriptionView = itemView.findViewById(R.id.description_view);
        mUrlView = itemView.findViewById(R.id.url);

        itemView.findViewById(R.id.item).setOnClickListener(view -> {
            if (mItemClickListener != null && mRepository != null) {
                mItemClickListener.onItemClick(getAdapterPosition(), mRepository);
            }
        });
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        mItemClickListener = itemClickListener;
    }

    public void setRepository(Repository repository){
        mRepository = repository;
        mNameTextView.setText(repository.getName());
        mDescriptionView.setText(repository.getDescription());
        mUrlView.setText(repository.getHtmlUrl());
    }

    public interface ItemClickListener {
        void onItemClick(int position, Repository repository);
    }
}
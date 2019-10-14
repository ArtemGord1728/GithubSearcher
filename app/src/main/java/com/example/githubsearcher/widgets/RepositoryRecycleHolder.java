package com.example.githubsearcher.widgets;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.githubsearcher.R;

import com.example.githubsearcher.models.Repository;

public class RepositoryRecycleHolder extends RecyclerView.ViewHolder {

    private TextView nameTextView;
    private TextView descriptionView;
    private TextView urlView;

    private Repository repository;
    private ItemClickListener itemClickListener;

    public RepositoryRecycleHolder(@NonNull View itemView) {
        super(itemView);
        nameTextView = itemView.findViewById(R.id.name_view);
        descriptionView = itemView.findViewById(R.id.description_view);
        urlView = itemView.findViewById(R.id.url);

        itemView.findViewById(R.id.item).setOnClickListener(view -> {
            if (itemClickListener != null && repository != null) {
                itemClickListener.onItemClick(getAdapterPosition(), repository);
            }
        });
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public void setRepository(Repository repository){
        this.repository = repository;
        nameTextView.setText(repository.getName());
        descriptionView.setText(repository.getDescription());
        urlView.setText(repository.getHtmlUrl());
    }

    public interface ItemClickListener {
        void onItemClick(int position, Repository repository);
    }
}
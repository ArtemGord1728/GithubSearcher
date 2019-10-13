package com.example.githubsearcher;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import core.RepositoriesAdapter;
import models.Repository;
import models.User;


public class MainActivity extends AppCompatActivity implements RepositoriesAdapter.ItemClickListener {

    private ImageView mAvatarView;
    private TextView mNameView;
    private TextView mSecondaryView;
    private TextView mEmptyView;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);

        mAvatarView = findViewById(R.id.avatar);
        mNameView = findViewById(R.id.name_view);
        mSecondaryView = findViewById(R.id.secondary_view);
        mEmptyView = findViewById(R.id.no_repositories);
        mRecyclerView = findViewById(R.id.recycler_view);

        Intent intent = getIntent();
        User user = intent.getParcelableExtra(User.USER);

        if (user == null) return;

        setUserInfo(user);
    }

    private void setUserInfo(User user) {
        Glide.with(this)
                .load(user.getAvatar())
                .apply(new RequestOptions()
                        .fitCenter()
                        .placeholder(R.drawable.ic_launcher_foreground))
                .into(mAvatarView);

        mNameView.setText(user.getName());
        mSecondaryView.setText(user.getSecondaryText());

        if (user.getRepositories().size() == 0) {
            mEmptyView.setVisibility(View.VISIBLE);
            mRecyclerView.setVisibility(View.GONE);
        } else {
            mEmptyView.setVisibility(View.GONE);
            mRecyclerView.setVisibility(View.VISIBLE);
            mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

            RepositoriesAdapter adapter = new RepositoriesAdapter(user.getRepositories());
            adapter.setItemClickListener(this);
            mRecyclerView.setAdapter(adapter);
        }
    }

    @Override
    public void onItemClick(int position, Repository repo) {
        if (repo.getHtmlUrl().equals("")) return;
        try {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(repo.getHtmlUrl())));
        } catch (ActivityNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.drawner_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        if(item.getItemId() == R.id.drawer_bookmarks){

        }
        ft.commit();
        return super.onOptionsItemSelected(item);
    }
}

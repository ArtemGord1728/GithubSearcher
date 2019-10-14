package com.example.githubsearcher.activity;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;


import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.githubsearcher.R;

import com.example.githubsearcher.activity.widgets.RepositoriesAdapter;
import com.example.githubsearcher.activity.database.SQLAppTools;
import com.example.githubsearcher.activity.models.Repository;
import com.example.githubsearcher.activity.models.User;

import io.reactivex.disposables.CompositeDisposable;


public class MainActivity extends AppCompatActivity implements RepositoriesAdapter.ItemClickListener {

    private ImageView mAvatarView;
    private TextView mNameView;
    private TextView mSecondaryView;
    private TextView mEmptyView;
    private RecyclerView mRecyclerView;
    private CompositeDisposable compositeDisposable;
    private SQLAppTools sqlAppTools;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);

        mAvatarView = findViewById(R.id.avatar);
        mNameView = findViewById(R.id.name_view);
        mSecondaryView = findViewById(R.id.secondary_view);
        mEmptyView = findViewById(R.id.no_repositories);
        mRecyclerView = findViewById(R.id.recycler_view);

        sqlAppTools = new SQLAppTools(this);
        compositeDisposable = new CompositeDisposable();

        ActionBar bar = getSupportActionBar();
        bar.setDisplayHomeAsUpEnabled(true);


        Intent intent = getIntent();
        User user = intent.getParcelableExtra(User.USER);

        if (user == null) return;

        setUserInfo(user);

        //btn_add.setOnClickListener(v -> compositeDisposable.add(Completable.fromAction(() -> sqlAppTools.addToFavorites(user))
        //.subscribeOn(Schedulers.io())
        //.observeOn(AndroidSchedulers.mainThread())
        //.subscribe()));
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
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.user_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case android.R.id.home:
                finish();
                break;

            case R.id.user_menu_add:

                break;

            case R.id.user_menu_remove:

                break;
        }
        return super.onOptionsItemSelected(item);
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
}

package com.example.githubsearcher.activity.constants;

public enum ApiConstants
{
    GITHUB_HOST("https://api.github.com/"),
    TABLE_NAME("favorites");

    ApiConstants(String url) {
        this.url = url;
    }

    private String url;
}

package core;

import java.util.List;

import models.UserSearchItem;

class UserSearchResponse {
    private long total_count;
    private boolean incomplete_results;
    private List<UserSearchItem> items;

    public List<UserSearchItem> getItems() {
        return items;
    }
}

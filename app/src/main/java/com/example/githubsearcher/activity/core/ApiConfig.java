package core;

import java.util.List;

import io.reactivex.Single;
import models.Repository;
import models.User;

public interface ApiConfig {
    byte CONNECT_TIMEOUT = 120;
    byte WRITE_TIMEOUT = 120;
    byte READ_TIMEOUT = 120;

    boolean noConnection();

    Single<User> getUser(String userName);

    Single<List<Repository>> getRepositories(String userName);
}

package pl.jankruk.it.forum.budowlane.database;

import pl.jankruk.it.forum.budowlane.entity.User;

public interface IAuthenticationDAO {
    void persistUser(User user);
    User findByLogin(String login);
}

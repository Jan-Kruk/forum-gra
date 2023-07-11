package pl.jankruk.it.forum.budowlane.database;

import pl.jankruk.it.forum.budowlane.entity.User;

public interface IUserDAO {
    User findUserById(int id);
}

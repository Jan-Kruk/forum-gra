package pl.jankruk.it.forum.budowlane.services;

import pl.jankruk.it.forum.budowlane.entity.User;

public interface IUserService {
    User findUserById(int id);
}

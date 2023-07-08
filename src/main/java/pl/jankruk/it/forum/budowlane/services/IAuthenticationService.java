package pl.jankruk.it.forum.budowlane.services;

import pl.jankruk.it.forum.budowlane.entity.User;

public interface IAuthenticationService {


    void persistUser(User user);

    User findByLogin(String login);
}

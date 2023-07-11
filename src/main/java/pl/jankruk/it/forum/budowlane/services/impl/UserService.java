package pl.jankruk.it.forum.budowlane.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.jankruk.it.forum.budowlane.database.IUserDAO;
import pl.jankruk.it.forum.budowlane.entity.User;
import pl.jankruk.it.forum.budowlane.services.IUserService;
@Service
public class UserService implements IUserService {
    IUserDAO userDAO;
@Autowired
    public UserService(IUserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public User findUserById(int id) {
        User user = userDAO.findUserById(id);
        user.setPassword(" ");
        return user;
    }
}

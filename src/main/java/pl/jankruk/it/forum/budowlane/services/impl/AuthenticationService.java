package pl.jankruk.it.forum.budowlane.services.impl;

import jakarta.annotation.Resource;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.DateUtils;
import pl.jankruk.it.forum.budowlane.database.IAuthenticationDAO;
import pl.jankruk.it.forum.budowlane.entity.User;
import pl.jankruk.it.forum.budowlane.exceptions.UserAlreadyExistException;
import pl.jankruk.it.forum.budowlane.services.IAuthenticationService;
import pl.jankruk.it.forum.budowlane.session.SessionData;
import pl.jankruk.it.forum.budowlane.utils.DateUtil;

@Service
public class AuthenticationService implements IAuthenticationService {
    IAuthenticationDAO authenticationDAO;
    @Resource
    SessionData sessionData;
    @Autowired
    public AuthenticationService(IAuthenticationDAO authenticationDAO) {
        this.authenticationDAO = authenticationDAO;
    }

    @Override
    public void persistUser(User user) throws UserAlreadyExistException{
        if (findByLogin(user.getLogin()) != null){
            throw new UserAlreadyExistException();
        }
        user.setCreationDate(DateUtil.getCurrentDate());
        user.setPassword(DigestUtils.md5Hex(user.getPassword()));
        user.setRole(User.Role.USER.toString());
        authenticationDAO.persistUser(user);
    }

    @Override
    public User findByLogin(String login) {
        return authenticationDAO.findByLogin(login);
    }

    @Override
    public void authenticate(String login, String password) {
        User user = findByLogin(login);
        if (user != null && user.getPassword().equals(DigestUtils.md5Hex(password))){
            user.setPassword("");
            sessionData.setUser(user);
        };
    }

}

package pl.jankruk.it.forum.budowlane.database.memory;

import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import pl.jankruk.it.forum.budowlane.database.IUserDAO;
import pl.jankruk.it.forum.budowlane.entity.User;

@Repository
public class UserDAO implements IUserDAO {

    EntityManager entityManager;

    public UserDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public User findUserById(int id) {
        return entityManager.find(User.class,id);
    }
}

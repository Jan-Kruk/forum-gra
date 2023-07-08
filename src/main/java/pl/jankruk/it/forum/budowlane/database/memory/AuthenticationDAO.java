package pl.jankruk.it.forum.budowlane.database.memory;

import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.jankruk.it.forum.budowlane.database.IAuthenticationDAO;
import pl.jankruk.it.forum.budowlane.entity.User;
@Repository
public class AuthenticationDAO implements IAuthenticationDAO {
    private EntityManager entityManager;

    public AuthenticationDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void persistUser(User user) {
    entityManager.persist(user);
    }

    @Override
    public User findByLogin(String login) {
        return entityManager.find(User.class, login);
    }
}

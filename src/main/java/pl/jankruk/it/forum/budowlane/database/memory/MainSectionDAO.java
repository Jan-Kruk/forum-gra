package pl.jankruk.it.forum.budowlane.database.memory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.jankruk.it.forum.budowlane.database.IMainSectionDAO;
import pl.jankruk.it.forum.budowlane.entity.MainSection;

import java.util.List;

@Repository
public class MainSectionDAO implements IMainSectionDAO {

   private EntityManager entityManager;
@Autowired
    public MainSectionDAO( EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void persistMainSection(MainSection mainSection) {
        entityManager.persist(mainSection);
    }

    @Override
    public List<MainSection> findAllMainSections() {
        TypedQuery<MainSection> typedQuery = entityManager.createQuery("From MainSection", MainSection.class);
        return typedQuery.getResultList();
    }

    @Override
    public MainSection findMainSection(int id) {
        return entityManager.find(MainSection.class,id);
    }
}

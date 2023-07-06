package pl.jankruk.it.forum.budowlane.database.memory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.jankruk.it.forum.budowlane.database.ISectionDAO;
import pl.jankruk.it.forum.budowlane.entity.Section;

import java.util.List;

@Repository
public class SectionDAO implements ISectionDAO {
    private EntityManager entityManager;
@Autowired
    public SectionDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void persistSection(Section section) {
        entityManager.persist(section);
    }

    @Override
    public List<Section> findAllSections() {
        TypedQuery<Section> typedQuery = entityManager.createQuery("From Section",Section.class);
        return typedQuery.getResultList();
    }
}

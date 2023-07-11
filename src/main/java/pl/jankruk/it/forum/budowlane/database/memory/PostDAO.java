package pl.jankruk.it.forum.budowlane.database.memory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import pl.jankruk.it.forum.budowlane.database.IPostDAO;
import pl.jankruk.it.forum.budowlane.entity.Answer;
import pl.jankruk.it.forum.budowlane.entity.Post;

import java.lang.reflect.Type;
import java.util.List;

@Repository
public class PostDAO implements IPostDAO {
    EntityManager entityManager;

    public PostDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void persistPost(Post post) {
     entityManager.persist(post);
    }

    @Override
    public List<Post> findAllPostsBySectionId(int id) {
        try{
        TypedQuery<Post> typedQuery = entityManager.createQuery("From Post where sectionId=:data",Post.class);
        typedQuery.setParameter("data",id);
        return typedQuery.getResultList();}
        catch (NoResultException e){
            return null;
        }
    }

    @Override
    public Post findPostById(int id) {
        return entityManager.find(Post.class,id);
    }

    @Override
    @Transactional
    public void persistAnswer(Answer answer) {
        entityManager.persist(answer);
    }

    @Override
    public List<Answer> findAllAnswersByPostId(int id) {
        TypedQuery<Answer> typedQuery = entityManager.createQuery("From Answer where postId=:data", Answer.class);
        typedQuery.setParameter("data",id);
        return typedQuery.getResultList();
    }
}

package pl.jankruk.it.forum.budowlane.database;

import pl.jankruk.it.forum.budowlane.entity.Answer;
import pl.jankruk.it.forum.budowlane.entity.Post;

import java.util.List;

public interface IPostDAO {
    void persistPost(Post post);
    List<Post> findAllPostsBySectionId(int id);
    Post findPostById(int id);
    void persistAnswer(Answer answer);
    List<Answer> findAllAnswersByPostId(int id);
}

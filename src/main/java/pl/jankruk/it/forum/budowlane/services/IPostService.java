package pl.jankruk.it.forum.budowlane.services;

import pl.jankruk.it.forum.budowlane.entity.Answer;
import pl.jankruk.it.forum.budowlane.entity.Post;

import java.util.List;

public interface IPostService {
    void persistPost(Post post);
    List<Post> findAllPostsBySectionId(int id);
    Post findPostById(int id);
    List<Post> findAllPosts();
    void persistAnswer(Answer answer);
    List<Answer> findAllAnswersByPostId(int id);
    List<Answer> findAllAnswers();

    List<Post> filterPostsByText(String word);
    List<Post> filerPostByTopic(String word);
    List<Answer> filterAnswersByText(String word);

}

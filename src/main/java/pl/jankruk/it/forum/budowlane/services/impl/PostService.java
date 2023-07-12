package pl.jankruk.it.forum.budowlane.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.jankruk.it.forum.budowlane.database.IPostDAO;
import pl.jankruk.it.forum.budowlane.entity.Answer;
import pl.jankruk.it.forum.budowlane.entity.Post;
import pl.jankruk.it.forum.budowlane.entity.Searchable;
import pl.jankruk.it.forum.budowlane.services.IPostService;
import pl.jankruk.it.forum.budowlane.utils.DateUtil;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService implements IPostService {
    IPostDAO postDAO;

    @Autowired
    public PostService(IPostDAO postDAO) {
        this.postDAO = postDAO;
    }

    @Override
    public void persistPost(Post post) {

        postDAO.persistPost(new Post(post.getTopic(),post.getText(),post.getUserID(),post.getSectionId(),DateUtil.getCurrentDate()));
    }

    @Override
    public List<Post> findAllPostsBySectionId(int id) {
        return postDAO.findAllPostsBySectionId(id);
    }

    @Override
    public Post findPostById(int id) {
        return postDAO.findPostById(id);
    }

    @Override
    public List<Post> findAllPosts() {
        return postDAO.findAllPosts();
    }

    @Override
    public void persistAnswer(Answer answer) {
        answer.setDate(DateUtil.getCurrentDate());
        postDAO.persistAnswer(answer);
    }

    @Override
    public List<Answer> findAllAnswersByPostId(int id) {
        return postDAO.findAllAnswersByPostId(id);
    }

    @Override
    public List<Answer> findAllAnswers() {
        return postDAO.findAllAnswers();
    }

    @Override
    public List<Post> filterPostsByText(String word) {
        String regex = "(.*)"+word+"(.*)";
        return findAllPosts().stream().filter(post -> post.getText().matches(regex)).collect(Collectors.toList());

    }

    @Override
    public List<Post> filerPostByTopic(String word) {
        String regex = "(.*)"+word+"(.*)";
        return findAllPosts().stream().filter(post -> post.getTopic().matches(regex)).collect(Collectors.toList());
    }
    @Override
    public List<Answer> filterAnswersByText(String word) {
        String regex = "(.*)"+word+"(.*)";
        return findAllAnswers().stream().filter(post -> post.getText().matches(regex)).collect(Collectors.toList());
    }


}

package pl.jankruk.it.forum.budowlane.controller;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.jankruk.it.forum.budowlane.entity.Answer;
import pl.jankruk.it.forum.budowlane.entity.Post;
import pl.jankruk.it.forum.budowlane.entity.Section;
import pl.jankruk.it.forum.budowlane.services.IPostService;
import pl.jankruk.it.forum.budowlane.services.ISectionService;
import pl.jankruk.it.forum.budowlane.services.IUserService;
import pl.jankruk.it.forum.budowlane.session.SessionData;

@Controller

public class PostController {
    @Resource
    SessionData sessionData;
    ISectionService sectionService;
    IPostService    postService;
    IUserService userService;
@Autowired
    public PostController(ISectionService sectionService, IPostService postService, IUserService userService) {
        this.sectionService = sectionService;
        this.postService = postService;
        this.userService = userService;
    }

    @RequestMapping(path = "sekcja/add/{id}",method = RequestMethod.GET)
    public String addPost(Model model, @PathVariable int id) {
        model.addAttribute("post",new Post());
        model.addAttribute("section",sectionService.findSectionById(id));
        ModelUtils.addCommonDataToModel(model,sessionData);
        return "/add-post";
    }
    @RequestMapping(path = "sekcja/add/{id}", method = RequestMethod.POST)
    public String persistPost(@ModelAttribute Post post, @PathVariable int id, @RequestParam int userId){
        if (!sessionData.isLogged()){
            return "redirect:/sekcja/" + sectionService.findSectionById(id).getTopic() + "/" + id;
        }
        post.setSectionId(id);
        post.setUserID(userId);
        postService.persistPost(post);
        return "redirect:/sekcja/" + sectionService.findSectionById(id).getTopic() + "/" + id;
    }

    @RequestMapping(path = "/temat/{postTopic}/{postId}", method = RequestMethod.GET)
    public String viewPost(@PathVariable int postId, Model model){
        Post post = postService.findPostById(postId);
        model.addAttribute("post",post);
        model.addAttribute("userPost",userService.findUserById(post.getUserID()));
        model.addAttribute("answer", new Answer());
        model.addAttribute("answerList",postService.findAllAnswersByPostId(postId));
        ModelUtils.addCommonDataToModel(model,sessionData);
        return "post";
    }

    @RequestMapping(path = "/temat/{postTopic}/{postId}", method = RequestMethod.POST)
    public String addAnswer(@PathVariable int postId, @PathVariable String postTopic, @ModelAttribute Answer answer, @RequestParam int userId){
        if (!sessionData.isLogged()){
            return "redirect:/temat/" + postTopic + "/"+postId;
        }
        answer.setPostId(postId);
        answer.setUserId(userId);
        answer.setAnswerUser(userService.findUserById(userId).getLogin());
        postService.persistAnswer(answer);
        return "redirect:/temat/" + postTopic + "/"+postId;
    }
}

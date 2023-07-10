package pl.jankruk.it.forum.budowlane.controller;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.jankruk.it.forum.budowlane.entity.Post;
import pl.jankruk.it.forum.budowlane.services.ISectionService;
import pl.jankruk.it.forum.budowlane.session.SessionData;

@Controller
@RequestMapping(path = "/sekcja")
public class PostController {
    @Resource
    SessionData sessionData;
    ISectionService sectionService;
@Autowired
    public PostController(ISectionService sectionService) {
        this.sectionService = sectionService;
    }

    @RequestMapping(path = "/add/{id}",method = RequestMethod.GET)
    public String Post(Model model, @PathVariable int id) {
        model.addAttribute("post",new Post());
        model.addAttribute("section",sectionService.findSectionById(id));
        ModelUtils.addCommonDataToModel(model,sessionData);
        return "add-post";
    }
    @RequestMapping(path = "/add/{id}", method = RequestMethod.POST)
    public String addPost(@ModelAttribute Post post, @PathVariable int id, @RequestParam int userId){
        System.out.println(post);
        System.out.println(id);
        System.out.println(userId);
        return "redirect:/index";
    }
}

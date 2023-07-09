package pl.jankruk.it.forum.budowlane.controller;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

    @RequestMapping(path = "/add/{SectionId}",method = RequestMethod.GET)
    public String addPost(Model model, @RequestParam int id) {
        model.addAttribute("section",sectionService.findSectionById(id));
        ModelUtils.addCommonDataToModel(model,sessionData);
        return "add-post";
    }
}

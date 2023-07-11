package pl.jankruk.it.forum.budowlane.controller;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.jankruk.it.forum.budowlane.services.IMainSectionService;
import pl.jankruk.it.forum.budowlane.services.IPostService;
import pl.jankruk.it.forum.budowlane.services.ISectionService;
import pl.jankruk.it.forum.budowlane.session.SessionData;

@Controller
@RequestMapping(path = "/sekcja")
public class SectionController {
    private ISectionService sectionService;
    private IPostService postService;

    @Resource
    SessionData sessionData;
@Autowired
    public SectionController(ISectionService sectionService, IPostService postService) {
        this.sectionService = sectionService;
        this.postService = postService;
    }



    @RequestMapping(path = "/{sectionName}/{id}", method = RequestMethod.GET)
    public String section(@PathVariable int id, Model model){
        model.addAttribute("Section",sectionService.findSectionById(id));
        model.addAttribute("PostList",postService.findAllPostsBySectionId(id));
        ModelUtils.addCommonDataToModel(model,sessionData);
        return "section";
    }

    }


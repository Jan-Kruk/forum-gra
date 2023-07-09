package pl.jankruk.it.forum.budowlane.controller;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.jankruk.it.forum.budowlane.services.IMainSectionService;
import pl.jankruk.it.forum.budowlane.services.ISectionService;
import pl.jankruk.it.forum.budowlane.session.SessionData;

@Controller
@RequestMapping(path = "/sekcja")
public class SectionController {
    private ISectionService sectionService;
    @Resource
    SessionData sessionData;
    @Autowired
    public SectionController(ISectionService sectionService) {
        this.sectionService = sectionService;
    }

    @RequestMapping(path = "/{sectionName}/{id}", method = RequestMethod.GET)
    public String section(@PathVariable int id, Model model){
        model.addAttribute("Section",sectionService.findSectionById(id));
        ModelUtils.addCommonDataToModel(model,sessionData);
        return "section";
    }

    }


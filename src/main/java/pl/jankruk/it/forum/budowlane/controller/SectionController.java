package pl.jankruk.it.forum.budowlane.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.jankruk.it.forum.budowlane.services.IMainSectionService;

@Controller
@RequestMapping(path = "/sekcja")
public class SectionController {
    private IMainSectionService mainSectionService;
@Autowired
    public SectionController(IMainSectionService mainSectionService) {
        this.mainSectionService = mainSectionService;
    }

    @RequestMapping(path = "/{sectionName}/{id}", method = RequestMethod.GET)
    public String section(@PathVariable int id, Model model){
        model.addAttribute("MainSection",mainSectionService.findMainSection(id));
        return "section";
    }

    }


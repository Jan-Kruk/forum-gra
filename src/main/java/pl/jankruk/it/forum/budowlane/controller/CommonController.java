package pl.jankruk.it.forum.budowlane.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.jankruk.it.forum.budowlane.entity.MainSection;
import pl.jankruk.it.forum.budowlane.services.IMainSectionService;
import pl.jankruk.it.forum.budowlane.services.impl.MainSectionService;

@Controller
public class CommonController {
    IMainSectionService mainSectionService;

    public CommonController(MainSectionService mainSectionService) {
        this.mainSectionService = mainSectionService;
    }

    @RequestMapping(path = {"/","/index"}, method = RequestMethod.GET)
    public String main(Model model){
        model.addAttribute("mainSection", new MainSection());
        model.addAttribute("mainSectionList", mainSectionService.getAllMainSections());
        return "index";
    }
    @RequestMapping(path = {"/","/index"}, method = RequestMethod.POST)
    public String addMainSection(@ModelAttribute MainSection mainSection){
        mainSectionService.persistMainSection(mainSection);
        return "redirect:/index";
    }
}

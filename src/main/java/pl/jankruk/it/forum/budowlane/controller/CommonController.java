package pl.jankruk.it.forum.budowlane.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.jankruk.it.forum.budowlane.entity.MainSection;
import pl.jankruk.it.forum.budowlane.entity.Section;
import pl.jankruk.it.forum.budowlane.services.IMainSectionService;
import pl.jankruk.it.forum.budowlane.services.ISectionService;

@Controller
public class CommonController {
    private IMainSectionService mainSectionService;
    private ISectionService sectionService;
@Autowired
    public CommonController(IMainSectionService mainSectionService, ISectionService sectionService) {
        this.mainSectionService = mainSectionService;
        this.sectionService = sectionService;
    }

    @RequestMapping(path = {"/","/index"}, method = RequestMethod.GET)
    public String main(Model model){
        model.addAttribute("mainSection", new MainSection());
        model.addAttribute("mainSectionList", mainSectionService.getAllMainSections());
        model.addAttribute("section", new Section());
        model.addAttribute("sections",sectionService.findAllSections());
        return "index";
    }
    @RequestMapping(path = {"/","/index"}, method = RequestMethod.POST)
    public String addMainSection(@ModelAttribute MainSection mainSection){
        mainSectionService.persistMainSection(mainSection);
        return "redirect:/index";
    }
    @RequestMapping(path = "/persistNewSection", method = RequestMethod.POST)
    public String addSection(@ModelAttribute Section section, @RequestParam int mainSectionId){
        section.setMainSectionId(mainSectionId);
        sectionService.persistSection(section);
        return "redirect:/index";
    }
}

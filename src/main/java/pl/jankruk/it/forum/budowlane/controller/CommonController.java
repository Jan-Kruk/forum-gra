package pl.jankruk.it.forum.budowlane.controller;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.jankruk.it.forum.budowlane.entity.MainSection;
import pl.jankruk.it.forum.budowlane.entity.Section;
import pl.jankruk.it.forum.budowlane.services.IMainSectionService;
import pl.jankruk.it.forum.budowlane.services.IPostService;
import pl.jankruk.it.forum.budowlane.services.ISectionService;
import pl.jankruk.it.forum.budowlane.session.SessionData;

@Controller
public class CommonController {
    private IMainSectionService mainSectionService;
    private ISectionService sectionService;

    private IPostService postService;
    @Resource
    SessionData sessionData;
    @Autowired
    public CommonController(IMainSectionService mainSectionService, ISectionService sectionService, IPostService postService) {
        this.mainSectionService = mainSectionService;
        this.sectionService = sectionService;
        this.postService = postService;
    }




    @RequestMapping(path = {"/","/index"}, method = RequestMethod.GET)
    public String main(Model model){
        model.addAttribute("mainSection", new MainSection());
        model.addAttribute("mainSectionList", mainSectionService.getAllMainSections());
        model.addAttribute("section", new Section());
        model.addAttribute("sections",sectionService.findAllSections());
        ModelUtils.addCommonDataToModel(model,sessionData);
        return "index";
    }
    @RequestMapping(path = {"/","/index"}, method = RequestMethod.POST)
    public String addMainSection(@ModelAttribute MainSection mainSection){
        if(!this.sessionData.isAdmin()) {
            return "redirect:/index";
        }
        mainSectionService.persistMainSection(mainSection);
        return "redirect:/index";
    }
    @RequestMapping(path = "/persistNewSection", method = RequestMethod.POST)
    public String addSection(@ModelAttribute Section section, @RequestParam int mainSectionId){
        if(!this.sessionData.isAdmin()) {
            return "redirect:/index";
        }
        section.setMainSectionId(mainSectionId);
        sectionService.persistSection(section);
        return "redirect:/index";
    }
    @RequestMapping(path = "/searchForValue", method = RequestMethod.GET)
    public String Search(Model model, @RequestParam String searchValue){
        System.out.println(postService.filterPostsByText(searchValue));
        return "redirect:/index";
    }
}

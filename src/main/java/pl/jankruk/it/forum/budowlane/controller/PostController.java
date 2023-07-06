package pl.jankruk.it.forum.budowlane.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(path = "/sekcja")
public class PostController {

    @RequestMapping(path = "/add/{SectionId}",method = RequestMethod.GET)
    public String addPost() {
        return "add-post";
    }
}

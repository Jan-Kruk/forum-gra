package pl.jankruk.it.forum.budowlane.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SectionController {
    @RequestMapping(path = "/sekcja/{id}", method = RequestMethod.GET)
    public String section(@PathVariable int id){
        System.out.println("hello world");
        System.out.println(id);
        return "section";
    }
}

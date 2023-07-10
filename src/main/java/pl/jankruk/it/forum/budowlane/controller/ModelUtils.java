package pl.jankruk.it.forum.budowlane.controller;

import org.springframework.ui.Model;
import pl.jankruk.it.forum.budowlane.session.SessionData;

public class ModelUtils {
    public static void addCommonDataToModel(Model model, SessionData sessionData) {
        model.addAttribute("logged", sessionData.isLogged());
        model.addAttribute("admin", sessionData.isAdmin());
        model.addAttribute("userName", sessionData.getName());
        model.addAttribute("userId",sessionData.getId());
        model.addAttribute("userDate",sessionData.getDate());
    }
}

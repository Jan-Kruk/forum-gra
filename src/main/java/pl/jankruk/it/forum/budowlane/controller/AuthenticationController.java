package pl.jankruk.it.forum.budowlane.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.jankruk.it.forum.budowlane.entity.User;
import pl.jankruk.it.forum.budowlane.exceptions.UserAlreadyExistException;
import pl.jankruk.it.forum.budowlane.exceptions.UserValidationException;
import pl.jankruk.it.forum.budowlane.services.IAuthenticationService;
import pl.jankruk.it.forum.budowlane.validators.UserValidator;

@Controller
public class AuthenticationController {
    private IAuthenticationService authenticationService;
@Autowired
    public AuthenticationController(IAuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @RequestMapping(path = "/register",method = RequestMethod.GET)
    public String register(Model model){
        model.addAttribute("userModel",new User());
        return "register";
    }
    @RequestMapping(path = "/login", method = RequestMethod.GET)
    public String login(Model model){
        return "login";
    }
    @RequestMapping(path = "/register", method = RequestMethod.POST)
    public String addNewUser(@ModelAttribute User user, @RequestParam String password2){
        try{
            UserValidator.validateUser(user);
            UserValidator.validatePasswordsEquality(user.getPassword(), password2);
            authenticationService.persistUser(user);
        }catch (UserValidationException | UserAlreadyExistException e){
            return "redirect:/login";
        }
        return "redirect:/index";
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String LoginUser(@RequestParam String login, @RequestParam String password){

    return "redirect:/index";
    }

}

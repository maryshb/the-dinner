package thedinnerapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import thedinnerapp.model.User;
import thedinnerapp.model.view.RegistrationModel;
import thedinnerapp.services.IUserService;
import thedinnerapp.session.SessionObject;

import javax.annotation.Resource;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class UserController {

    private IUserService userService;
    private SessionObject sessionObject;

    @Autowired
    public UserController(IUserService userService, SessionObject sessionObject) {
        this.userService = userService;
        this.sessionObject = sessionObject;
    }

    @GetMapping(value = "/login")
    public String loginForm(Model model) {
        if (this.sessionObject.isLogged()) {
            return "redirect:/main";
        }
        model.addAttribute("userModel", new User());
        return "login";
    }

    @PostMapping(value = "/login")
    public String login(@ModelAttribute User user) {
        this.userService.authenticate(user);
        if (this.sessionObject.isLogged()) {
            return "redirect:/main";
        }
        return "redirect:/login";
    }

    @GetMapping(value = "/logout")
    public String logout() {
        this.userService.logout();
        return "redirect:/login";
    }


    @GetMapping(value = "/register")
    public String registerForm(Model model) {
        model.addAttribute("registrationModel", new RegistrationModel());
        model.addAttribute("info", this.sessionObject.getInfo());
        return "/register";
    }

    @PostMapping(value = "/register")
    public String register(@ModelAttribute RegistrationModel registrationModel) {
        Pattern regexp = Pattern.compile("[A-Za-z0-9]{5}.*");
        Matcher loginMatcher = regexp.matcher(registrationModel.getLogin());
        Matcher passMatcher = regexp.matcher(registrationModel.getPass());
        Matcher pass2Matcher = regexp.matcher(registrationModel.getPass2());

        if (!loginMatcher.matches() || !passMatcher.matches() || !pass2Matcher.matches() || !registrationModel.getPass().equals(registrationModel.getPass2())) {
            this.sessionObject.setInfo("Validation error");
            return "redirect:/register";
        }

        if (this.userService.register(registrationModel)) {
            return "redirect:/login";
        } else {
            this.sessionObject.setInfo("Login zajęty!");
            return "redirect:/register";
        }

    }
}

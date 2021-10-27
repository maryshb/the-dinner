package thedinnerapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import thedinnerapp.model.Restaurant;
import thedinnerapp.services.impl.RestaurantServiceImpl;
import thedinnerapp.session.SessionObject;

import javax.annotation.Resource;
import java.util.Arrays;

@Controller
public class CommonController {

    @Autowired
    RestaurantServiceImpl restaurantService;



    @Resource
    SessionObject sessionObject;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String landingPage() { return "redirect:/main"; }

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String main(Model model) {
        model.addAttribute("restaurants", this.restaurantService.getAllRestaurants());
        model.addAttribute("cuisines",Arrays.asList(Restaurant.Cuisine.values()));
        model.addAttribute("isLogged", this.sessionObject.isLogged());
        model.addAttribute("role", this.sessionObject.isLogged() ? this.sessionObject.getLoggedUser().getRole().toString() : null);

        System.out.println(Arrays.asList(Restaurant.Cuisine.values()));
        return "main";
    }


    @RequestMapping(value = "/contact", method = RequestMethod.GET)
    public String contact(Model model){
        model.addAttribute("isLogged", this.sessionObject.isLogged());
        return "contact";
    }

    @RequestMapping (path = "/kategorie")
    public String greetingSubmit(@ModelAttribute Restaurant.Cuisine cuisine, Model model) {
        model.addAttribute("cuisine", cuisine);
        model.addAttribute("isLogged", this.sessionObject.isLogged());
        return "contact";
    }


}

package thedinnerapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import thedinnerapp.model.Restaurant;
import thedinnerapp.services.IItemService;
import thedinnerapp.services.impl.RestaurantServiceImpl;
import thedinnerapp.session.SessionObject;

import javax.annotation.Resource;

@Controller
public class CommonController {

    @Autowired
    RestaurantServiceImpl restaurantService;

    @Autowired
    IItemService itemService;


    @Resource
    SessionObject sessionObject;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String landingPage() {
        return "redirect:/main";
    }

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String main(Model model) {
        model.addAttribute("restaurants", this.restaurantService.getAllRestaurants());
        model.addAttribute("cuisines", Restaurant.Cuisine.values());
        model.addAttribute("isLogged", this.sessionObject.isLogged());
        model.addAttribute("role", this.sessionObject.isLogged() ? this.sessionObject.getLoggedUser().getRole().toString() : null);
        return "main";
    }

    @RequestMapping(value = "/contact", method = RequestMethod.GET)
    public String contact(Model model) {
        model.addAttribute("isLogged", this.sessionObject.isLogged());
        return "contact";
    }

    @RequestMapping(path = "/kategorie")
    public String greetingSubmit(@ModelAttribute Restaurant.Cuisine cuisine, Model model) {
        model.addAttribute("cuisine", cuisine);
        model.addAttribute("isLogged", this.sessionObject.isLogged());
        return "contact";
    }

    @RequestMapping(path = "/restaurant/{id}", method = RequestMethod.GET)
    public String restaurant(@PathVariable int id, Model model) {
        model.addAttribute("isLogged", this.sessionObject.isLogged());
        model.addAttribute("restaurant", this.restaurantService.getRestaurantById(id));
        model.addAttribute("items", this.itemService.getItemsByRestaurantId(id));
        model.addAttribute("role", this.sessionObject.isLogged() ? this.sessionObject.getLoggedUser().getRole().toString() : null);
        return "restaurant";
    }


}

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

    private RestaurantServiceImpl restaurantService;
    private IItemService itemService;
    private SessionObject sessionObject;

    @Autowired
    public CommonController(RestaurantServiceImpl restaurantService, IItemService itemService, SessionObject sessionObject) {
        this.restaurantService = restaurantService;
        this.itemService = itemService;
        this.sessionObject = sessionObject;
    }

    @GetMapping(value = "/")
    public String landingPage() {
        return "redirect:/main";
    }

    @GetMapping(value = "/main")
    public String main(Model model) {
        model.addAttribute("restaurants", this.restaurantService.getAllRestaurants());
        model.addAttribute("cuisines", Restaurant.Cuisine.values());
        model.addAttribute("isLogged", this.sessionObject.isLogged());
        model.addAttribute("role", this.sessionObject.isLogged() ? this.sessionObject.getLoggedUser().getRole().toString() : null);
        return "main";
    }

    @GetMapping(value = "/contact")
    public String contactPage(Model model) {
        model.addAttribute("isLogged", this.sessionObject.isLogged());
        return "contact";
    }

    @GetMapping(path = "/category/{cuisine}")
    public String categoryPage(@ModelAttribute Restaurant.Cuisine cuisine, Model model) {
        model.addAttribute("isLogged", this.sessionObject.isLogged());
        model.addAttribute("role", this.sessionObject.isLogged() ? this.sessionObject.getLoggedUser().getRole().toString() : null);
        model.addAttribute("restaurants", this.restaurantService.getRestaurantsByCuisine(cuisine));
        model.addAttribute("cuisines", Restaurant.Cuisine.values());
        model.addAttribute("cuisine", cuisine);
        return "main";
    }

    @GetMapping(path = "/restaurant/{id}")
    public String restaurantPage(@PathVariable int id, Model model) {
        model.addAttribute("isLogged", this.sessionObject.isLogged());
        model.addAttribute("role", this.sessionObject.isLogged() ? this.sessionObject.getLoggedUser().getRole().toString() : null);
        model.addAttribute("restaurant", this.restaurantService.getRestaurantById(id));
        model.addAttribute("items", this.itemService.getItemsByRestaurantId(id));
        return "restaurant";
    }
}

package thedinnerapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import thedinnerapp.model.Item;
import thedinnerapp.model.Restaurant;
import thedinnerapp.model.User;
import thedinnerapp.services.IItemService;
import thedinnerapp.services.IRestaurantService;
import thedinnerapp.session.SessionObject;

import javax.annotation.Resource;

@Controller
public class AdminController {

    private SessionObject sessionObject;
    private IRestaurantService restaurantService;
    private IItemService itemService;

    @Autowired
    public AdminController(SessionObject sessionObject, IRestaurantService restaurantService, IItemService itemService) {
        this.sessionObject = sessionObject;
        this.restaurantService = restaurantService;
        this.itemService = itemService;
    }

    @GetMapping(value = "/add-restaurant")
    public String addRestaurantForm(Model model) {
        if (!this.sessionObject.isLogged() || this.sessionObject.getLoggedUser().getRole() != User.Role.ADMIN) {
            return "redirect:/login";
        }
        model.addAttribute("isLogged", this.sessionObject.isLogged());
        model.addAttribute("restaurantModel", new Restaurant());
        return "/add-restaurant";
    }

    @PostMapping(value = "/add-restaurant")
    public String addRestaurantSubmit(@ModelAttribute Restaurant restaurant) {
        this.restaurantService.addRestaurant(restaurant);
        return "redirect:/main";
    }

    @GetMapping(value = "/edit/{id}")
    public String editRestaurantForm(@PathVariable int id, Model model) {
        if (!this.sessionObject.isLogged() || this.sessionObject.getLoggedUser().getRole() != User.Role.ADMIN) {
            return "redirect:/login";
        }
        Restaurant restaurant = this.restaurantService.getRestaurantById(id);
        model.addAttribute("restaurant", restaurant);
        model.addAttribute("isLogged", this.sessionObject.isLogged());
        model.addAttribute("role", this.sessionObject.isLogged() ? this.sessionObject.getLoggedUser().getRole().toString() : null);
        return "edit";
    }

    @PostMapping(value = "/edit/{id}")
    public String editRestaurantSubmit(@ModelAttribute Restaurant restaurant, @PathVariable int id) {
        restaurant.setRestaurantId(id);
        if (!this.sessionObject.isLogged() || this.sessionObject.getLoggedUser().getRole() != User.Role.ADMIN) {
            return "redirect:/login";
        }
        this.restaurantService.updateRestaurant(restaurant);
        return "redirect:/main";
    }

    @GetMapping(value = "/remove/{id}")
    public String removeRestaurant(@PathVariable int id) {
        if (!this.sessionObject.isLogged() || this.sessionObject.getLoggedUser().getRole() != User.Role.ADMIN) {
            return "redirect:/login";
        }
        this.restaurantService.removeRestaurant(this.restaurantService.getRestaurantById(id));
        return "redirect:/main";
    }

    @GetMapping(value = "/add-item/{id}")
    public String addItemForm(Model model, @PathVariable int id) {
        if (!this.sessionObject.isLogged() || this.sessionObject.getLoggedUser().getRole() != User.Role.ADMIN) {
            return "redirect:/login";
        }
        model.addAttribute("isLogged", this.sessionObject.isLogged());
        model.addAttribute("itemModel", new Item());
        return "/add-item";
    }

    @PostMapping(value = "/add-item/{id}")
    public String addItemSubmit(@ModelAttribute Item item, @PathVariable int id) {
        item.setRestaurant(this.restaurantService.getRestaurantById(id));
        this.itemService.addItem(item);
        return "redirect:/main";
    }
}






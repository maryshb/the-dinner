package thedinnerapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import thedinnerapp.model.Item;
import thedinnerapp.model.Restaurant;
import thedinnerapp.model.User;
import thedinnerapp.services.IItemService;
import thedinnerapp.services.IRestaurantService;
import thedinnerapp.session.SessionObject;

import javax.annotation.Resource;

@Controller
public class AdminController {

    @Resource
    SessionObject sessionObject;

    @Autowired
    IRestaurantService restaurantService;

    @Autowired
    IItemService itemService;

    @RequestMapping(value = "/add-restaurant", method = RequestMethod.GET)
    public String addRestaurantForm(Model model) {
        if (!this.sessionObject.isLogged() || this.sessionObject.getLoggedUser().getRole() != User.Role.ADMIN) {
            return "redirect:/login";
        }
        model.addAttribute("isLogged", this.sessionObject.isLogged());
        model.addAttribute("restaurantModel", new Restaurant());
        return "/add-restaurant";
    }

    @RequestMapping(value = "/add-restaurant", method = RequestMethod.POST)
    public String addRestaurantSubmit(@ModelAttribute Restaurant restaurant) {
        this.restaurantService.addRestaurant(restaurant);
        return "redirect:/main";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
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

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String editRestaurantSubmit(@ModelAttribute Restaurant restaurant, @PathVariable int id) {
        restaurant.setRestaurantId(id);
        if (!this.sessionObject.isLogged() || this.sessionObject.getLoggedUser().getRole() != User.Role.ADMIN) {
            return "redirect:/login";
        }
        this.restaurantService.updateRestaurant(restaurant);
        return "redirect:/main";
    }

    @RequestMapping(value = "/remove/{id}", method = RequestMethod.GET)
    public String removeRestaurant(@PathVariable int id) {
        if (!this.sessionObject.isLogged() || this.sessionObject.getLoggedUser().getRole() != User.Role.ADMIN) {
            return "redirect:/login";
        }
        this.restaurantService.removeRestaurant(this.restaurantService.getRestaurantById(id));
        return "redirect:/main";
    }

    @RequestMapping(value = "/add-item/{id}", method = RequestMethod.GET)
    public String addItemForm(Model model, @PathVariable int id) {
        if (!this.sessionObject.isLogged() || this.sessionObject.getLoggedUser().getRole() != User.Role.ADMIN) {
            return "redirect:/login";
        }
        model.addAttribute("isLogged", this.sessionObject.isLogged());
        model.addAttribute("itemModel", new Item());
        return "/add-item";
    }

    @RequestMapping(value = "/add-item/{id}", method = RequestMethod.POST)
    public String addItemSubmit(@ModelAttribute Item item, @PathVariable int id) {
        item.setRestaurant(this.restaurantService.getRestaurantById(id));
        this.itemService.addItem(item);
        return "redirect:/main";
    }
}






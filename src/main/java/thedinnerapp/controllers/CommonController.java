package thedinnerapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import thedinnerapp.services.impl.RestaurantServiceImpl;

@Controller
public class CommonController {

    @Autowired
    RestaurantServiceImpl restaurantService;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String landingPage() { return "redirect:/main"; }

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String main(Model model) {
        model.addAttribute("restaurants", this.restaurantService.getAllRestaurants());
        return "main";
    }
}

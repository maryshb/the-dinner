package thedinnerapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import thedinnerapp.services.IBasketService;
import thedinnerapp.session.SessionObject;

import javax.annotation.Resource;

@Controller
public class BasketController {

    private IBasketService basketService;
    private SessionObject sessionObject;

    @Autowired
    public BasketController(IBasketService basketService, SessionObject sessionObject) {
        this.basketService = basketService;
        this.sessionObject = sessionObject;
    }

    @GetMapping(value = "/basket")
    public String basketPage(Model model) {
        if (!this.sessionObject.isLogged()) {
            return "redirect:/login";
        }
        model.addAttribute("items", this.sessionObject.getBasket());
        model.addAttribute("isLogged", this.sessionObject.isLogged());
        model.addAttribute("sum", this.basketService.calculateTotal());
        return "basket";
    }

    @GetMapping(value = "/addToBasket/{id}")
    public String addToBasket(@PathVariable int id) {
        if (!this.sessionObject.isLogged()) {
            return "redirect:/login";
        }
        this.basketService.addItemByIdToBasket(id);
        return "redirect:/main";
    }

    @GetMapping(value = "/removeFromBasket/{id}")
    public String removeFromBasket(@PathVariable int id) {
        if (!this.sessionObject.isLogged()) {
            return "redirect:/login";
        }
        this.basketService.removeItemByIdFromBasket(id);
        return "redirect:/main";
    }
}

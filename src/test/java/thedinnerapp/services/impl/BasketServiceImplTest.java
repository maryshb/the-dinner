package thedinnerapp.services.impl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import thedinnerapp.configuration.AppConfiguration;
import thedinnerapp.model.Item;
import thedinnerapp.model.Restaurant;
import thedinnerapp.services.IBasketService;
import thedinnerapp.session.SessionObject;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfiguration.class})
@WebAppConfiguration
public class BasketServiceImplTest {

    @Autowired
    IBasketService basketService;

    @Resource
    SessionObject sessionObject;

    @Test
    public void calculateTotalTest() {
        Restaurant restaurant = new Restaurant();
        sessionObject.getBasket().add(new Item(1, "Item", "ABCD", 10, 1, restaurant ));
        sessionObject.getBasket().add(new Item(2, "Item2", "ABCD2", 20, 1, restaurant ));
        sessionObject.getBasket().add(new Item(3, "Item3", "ABCD3", 30, 1, restaurant ));

        double expectedResult = 60;
        double result = this.basketService.calculateTotal();

        Assertions.assertEquals(expectedResult, result);

    }
}

package thedinnerapp.services.impl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatcher;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import thedinnerapp.configuration.TestConfiguration;
import thedinnerapp.dao.IItemDAO;
import thedinnerapp.dao.IRestaurantDAO;
import thedinnerapp.dao.IUserDAO;
import thedinnerapp.model.User;
import thedinnerapp.model.view.RegistrationModel;
import thedinnerapp.services.IBasketService;
import thedinnerapp.services.IItemService;
import thedinnerapp.services.IRestaurantService;
import thedinnerapp.services.IUserService;
import thedinnerapp.session.SessionObject;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestConfiguration.class})
@WebAppConfiguration
public class UserServiceImplTest {

    @Autowired
    IUserService userService;

    @Autowired
    IBasketService basketService;

    @Autowired
    IRestaurantService restaurantService;

    @Autowired
    IItemService itemService;

    @MockBean
    IUserDAO userDAO;

    @MockBean
    IItemDAO itemDAO;

    @MockBean
    IRestaurantDAO restaurantDAO;

    @Resource
    SessionObject sessionObject;

    @Test
    public void registerTest() {
        RegistrationModel registrationModel = new RegistrationModel("Adam", "Nowak", "adanow123", "adanow@email.com", "adanow123", "adanow123");
        Mockito.when(this.userDAO.getUserByLogin("adanow123")).thenReturn(null);
        Mockito.when(this.userDAO.persistUser(ArgumentMatchers.any())).thenReturn(true);

        boolean result = this.userService.register(registrationModel);

        Assertions.assertTrue(result);
    }


    @Test
    public void loginTest() {
        User user = new User(1, "Adam", "Nowak", "adanow123", "adanow@email.com", "adanow123", User.Role.USER);
        Mockito.when(this.userDAO.getUserByLogin("adanow123")).thenReturn(new User(1, "Adam", "Nowak", "adanow123", "adanow@email.com", "adanow123", User.Role.USER));

        this.userService.authenticate(user);

        Assert.assertNotNull(this.sessionObject.getLoggedUser());

    }

    @Test
    public void passwordTest() {
        User user = new User(1, "Adam", "Nowak", "adanow123", "adanow@email.com", "adanow123", User.Role.USER);
        Mockito.when(this.userDAO.getUserByLogin("tomek123")).thenReturn(new User(1, "Adam", "Nowak", "adanow123", "adanow@email.com", "adanow333", User.Role.USER));

        this.userService.authenticate(user);

        Assert.assertNull(this.sessionObject.getLoggedUser());
    }



}

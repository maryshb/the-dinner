package thedinnerapp.services.impl;
import org.junit.Assert;
import org.junit.Test;
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
import thedinnerapp.services.IUserService;
import thedinnerapp.session.SessionObject;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestConfiguration.class})
@WebAppConfiguration
public class UserServiceImplTest {

    @Autowired
    IUserService userService;

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
        RegistrationModel registrationModel = new RegistrationModel();
        registrationModel.setName("Adam");
        registrationModel.setLastname("Nowak");
        registrationModel.setLogin("adanow");
        registrationModel.setEmail("adanow@mail.com");
        registrationModel.setPass("adam");
        registrationModel.setPass2("adam");

        Mockito.when(this.userDAO.getUserByLogin("adanow")).thenReturn(null);
        Mockito.when(this.userDAO.persistUser(ArgumentMatchers.any())).thenReturn(true);
        boolean result = userService.register(registrationModel);
        Assert.assertTrue(result);
    }

}

package thedinnerapp.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thedinnerapp.dao.impl.RestaurantDAOImpl;
import thedinnerapp.model.Restaurant;
import thedinnerapp.services.IRestaurantService;

import java.util.List;

@Service
public class RestaurantServiceImpl implements IRestaurantService {
    @Autowired
    RestaurantDAOImpl restaurantDAO;

    @Override
    public Restaurant getRestaurantById(int id) {
        return this.restaurantDAO.getRestaurantById(id);
    }

    @Override
    public List<Restaurant> getAllRestaurants() {
        return this.restaurantDAO.getAllRestaurants();
    }
}

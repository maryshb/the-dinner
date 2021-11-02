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

    @Override
    public List<Restaurant> getRestaurantsByCuisine(Restaurant.Cuisine cuisine) {
        return this.restaurantDAO.getRestaurantsByCuisine(cuisine);
    }

    @Override
    public void addRestaurant(Restaurant restaurant) {
        // TODO sprawdzenie czy istnieje restauracja, sprawdzenie poprawności wprowadzonych danych
        this.restaurantDAO.persistRestaurant(restaurant);
    }

    @Override
    public void updateRestaurant(Restaurant restaurant) {
        Restaurant restaurantFromDB = this.restaurantDAO.getRestaurantById(restaurant.getRestaurantId());
        restaurantFromDB.setRestaurantName(restaurant.getRestaurantName());
        restaurantFromDB.setPhone(restaurant.getPhone());
        restaurantFromDB.setAddress(restaurant.getAddress());
        restaurantFromDB.setCuisine(restaurant.getCuisine());

        this.restaurantDAO.updateRestaurant(restaurantFromDB);

    }

    @Override
    public void removeRestaurant(Restaurant restaurant) {
        this.restaurantDAO.removeRestaurant(restaurant);
    }
}

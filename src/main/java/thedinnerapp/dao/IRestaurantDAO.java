package thedinnerapp.dao;

import thedinnerapp.model.Restaurant;

import java.util.List;

public interface IRestaurantDAO {
    Restaurant getRestaurantById(int id);
    List<Restaurant> getRestaurantsByCuisine(Restaurant.Cuisine cuisine);
    List<Restaurant> getAllRestaurants();
    void persistRestaurant(Restaurant restaurant);
    void updateRestaurant(Restaurant restaurant);
    void removeRestaurant(Restaurant restaurant);
}

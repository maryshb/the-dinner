package thedinnerapp.services;

import thedinnerapp.model.Restaurant;

import java.util.List;

public interface IRestaurantService {
    Restaurant getRestaurantById(int id);
    List<Restaurant> getAllRestaurants();
    List<Restaurant> getRestaurantsByCuisine(Restaurant.Cuisine cuisine);
    void addRestaurant(Restaurant restaurant);
    void updateRestaurant(Restaurant restaurant);
    void removeRestaurant(Restaurant restaurant);
}

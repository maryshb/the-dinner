package thedinnerapp.dao;

import thedinnerapp.model.Restaurant;

import java.util.List;

public interface IRestaurantDAO {
    Restaurant getRestaurantById(int id);
    List<Restaurant> getAllRestaurants();
    // TODO Add/Edit restaurant

}

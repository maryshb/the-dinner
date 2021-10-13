package thedinnerapp.services;

import thedinnerapp.model.Restaurant;

import java.util.List;

public interface IRestaurantService {
    Restaurant getRestaurantById(int id);
    List<Restaurant> getAllRestaurants();
    // TODO Add/Edit restaurant

}

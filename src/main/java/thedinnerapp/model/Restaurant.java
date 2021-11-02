package thedinnerapp.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Data
@Entity(name = "trestaurant")
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int restaurantId;
    private String restaurantName;
    private String phone;
    private String address;
    private Cuisine cuisine;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "restaurant")
    private Collection<Item> items;


    public Restaurant() {

    }

    public Restaurant(int restaurantId, String restaurantName, String phone, String address, double rating) {
        this.restaurantId = restaurantId;
        this.restaurantName = restaurantName;
        this.phone = phone;
        this.address = address;
        this.cuisine = cuisine;
    }


    public enum Cuisine {
        AMERICAN,
        ASIAN,
        BURGER,
        KEBAB,
        POLISH,
        PIZZA,
        ITALIAN
    }

//    public ArrayList<Restaurant.Cuisine> getAllCuisines(){
//        ArrayList<Restaurant.Cuisine> cuisines = new ArrayList<Restaurant.Cuisine>();
//        return cuisines;
//   }


}

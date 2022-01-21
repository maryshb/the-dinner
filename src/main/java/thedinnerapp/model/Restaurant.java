package thedinnerapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "trestaurant")
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int restaurantId;
    private String restaurantName;
    private String phone;
    private String address;
    @Enumerated(EnumType.STRING)
    private Cuisine cuisine;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "restaurant")
    private Collection<Item> items;

    public enum Cuisine {
        AMERICAN,
        ASIAN,
        BURGER,
        KEBAB,
        POLISH,
        PIZZA,
        ITALIAN
    }
}

package thedinnerapp.model;

import lombok.Data;
import lombok.Getter;

import javax.persistence.*;

@Data
@Entity(name = "titem")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int itemId;
    private String itemName;
    private String description;
    double price;
    private int pieces;
    @ManyToOne
    @JoinColumn(name = "restaurantId")
    private Restaurant restaurant;

    public Item() {
    }

    public Item(int itemId, String itemName, String description, double price, int pieces, Restaurant restaurant) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.description = description;
        this.price = price;
        this.pieces = pieces;
        this.restaurant = restaurant;
    }
}


package thedinnerapp.services;

import thedinnerapp.model.Item;
import thedinnerapp.model.Restaurant;

import java.util.List;

public interface IItemService {
    Item getItemById(int id);
    List<Item> getItemsByRestaurantId(int id);
    void addItem(Item item);
    void updateItem(Item item);
    void removeItem(Item item);

}

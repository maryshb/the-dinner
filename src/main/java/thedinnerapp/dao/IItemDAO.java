package thedinnerapp.dao;

import thedinnerapp.model.Item;

import java.util.List;

public interface IItemDAO {
    Item getItemById(int id);
    List<Item> getItemsByRestaurantId(int id);
    void removeItem(Item item);
    void updateItem(Item item);
    void persistItem(Item item);
}

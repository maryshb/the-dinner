package thedinnerapp.services;

import thedinnerapp.model.Item;
import thedinnerapp.model.Restaurant;

public interface IBasketService {
    double calculateTotal();

    void addItemByIdToBasket(int id);
    void removeItemByIdFromBasket(int id);

    void addItem(Item item);
    void updateItem(Item item);
    void removeItem(Item item);
}

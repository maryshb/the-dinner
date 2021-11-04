package thedinnerapp.services;

public interface IBasketService {
    double calculateTotal();
    void addItemByIdToBasket(int id);
    void removeItemByIdFromBasket(int id);
}

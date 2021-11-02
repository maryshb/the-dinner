package thedinnerapp.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thedinnerapp.dao.IItemDAO;
import thedinnerapp.model.Item;
import thedinnerapp.model.Restaurant;
import thedinnerapp.services.IBasketService;
import thedinnerapp.session.SessionObject;

import javax.annotation.Resource;
import java.util.List;
import java.util.ListIterator;

@Service
public class BasketServiceImpl implements IBasketService {

    @Autowired
    IItemDAO itemDAO;

    @Resource
    SessionObject sessionObject;


    @Override
    public double calculateTotal() {
        double sum = 0;
        for (Item item : this.sessionObject.getBasket()) {
            sum = sum + item.getPrice() * item.getPieces();
        }
        return sum;
    }

    @Override
    public void addItemByIdToBasket(int id) {
        Item item = this.itemDAO.getItemById(id);
        for (Item itemFromBasket : this.sessionObject.getBasket()) {
            if (itemFromBasket.getItemId() == item.getItemId()) {
                itemFromBasket.setPieces(itemFromBasket.getPieces() + 1);
                return;
            }
        }
        item.setPieces(1);
        this.sessionObject.getBasket().add(item);
    }

    @Override
    public void removeItemByIdFromBasket(int id) {
        Item item = this.itemDAO.getItemById(id);
        List<Item> itemsFromBasket = this.sessionObject.getBasket();
        ListIterator<Item> iter = itemsFromBasket.listIterator();
        while (iter.hasNext()) {
            if (iter.next().getItemId() == item.getItemId()) {
                iter.remove();
            }
        }
        this.sessionObject.setBasket(itemsFromBasket);
    }

    @Override
    public void addItem(Item item) {
        this.itemDAO.persistItem(item);
    }

    @Override
    public void updateItem(Item item) {
        Item itemFromDB = this.itemDAO.getItemById(item.getItemId());
        itemFromDB.setItemName(item.getItemName());
        itemFromDB.setDescription(item.getDescription());
        itemFromDB.setPrice(item.getPrice());
        this.itemDAO.updateItem(itemFromDB);
    }


    @Override
    public void removeItem(Item item) {
        this.itemDAO.removeItem(item);
    }
}

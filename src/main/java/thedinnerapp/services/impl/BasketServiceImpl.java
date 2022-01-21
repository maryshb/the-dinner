package thedinnerapp.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thedinnerapp.dao.IItemDAO;
import thedinnerapp.model.Item;
import thedinnerapp.services.IBasketService;
import thedinnerapp.session.SessionObject;

import java.util.List;
import java.util.ListIterator;

@Service
public class BasketServiceImpl implements IBasketService {

    private IItemDAO itemDAO;
    private SessionObject sessionObject;

    @Autowired
    public BasketServiceImpl(IItemDAO itemDAO, SessionObject sessionObject) {
        this.itemDAO = itemDAO;
        this.sessionObject = sessionObject;
    }

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
}

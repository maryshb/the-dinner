package thedinnerapp.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thedinnerapp.dao.IItemDAO;
import thedinnerapp.model.Item;
import thedinnerapp.model.Restaurant;
import thedinnerapp.services.IItemService;

import java.util.List;

@Service
public class ItemServiceImpl implements IItemService {

    @Autowired
    IItemDAO itemDAO;

    @Override
    public Item getItemById(int id) {
        return this.itemDAO.getItemById(id);
    }

    @Override
    public List<Item> getItemsByRestaurantId(int id) {
        return this.itemDAO.getItemsByRestaurantId(id);
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

package thedinnerapp.dao;

import thedinnerapp.model.Order;

public interface IOrderDAO {
    void saveOrder(Order order);
    Order getOrderById(int id);
}

package thedinnerapp.services;

import thedinnerapp.model.Order;

public interface IOrderService {
    void saveOrder(Order order);
    Order getOrderById(int id);
}

package thedinnerapp.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import thedinnerapp.dao.IOrderDAO;
import thedinnerapp.model.Order;
import thedinnerapp.services.IOrderService;

public class OrderServiceImpl implements IOrderService {

    @Autowired
    IOrderDAO orderDAO;

    @Override
    public void saveOrder(Order order) {
        this.orderDAO.saveOrder(order);
    }

    @Override
    public Order getOrderById(int id) {
        return this.orderDAO.getOrderById(id);
    }
}

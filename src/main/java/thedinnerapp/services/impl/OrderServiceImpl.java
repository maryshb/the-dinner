package thedinnerapp.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thedinnerapp.dao.IOrderDAO;
import thedinnerapp.model.Order;
import thedinnerapp.services.IOrderService;

@Service
public class OrderServiceImpl implements IOrderService {
    
    private IOrderDAO orderDAO;

    @Autowired
    public OrderServiceImpl(IOrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    @Override
    public void saveOrder(Order order) {
        this.orderDAO.saveOrder(order);
    }

    @Override
    public Order getOrderById(int id) {
        return this.orderDAO.getOrderById(id);
    }
}

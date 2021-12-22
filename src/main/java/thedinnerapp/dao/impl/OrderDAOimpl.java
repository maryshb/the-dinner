package thedinnerapp.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import thedinnerapp.dao.IOrderDAO;
import thedinnerapp.model.Order;

@Repository
public class OrderDAOimpl implements IOrderDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public OrderDAOimpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void saveOrder(Order order) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(order);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }

    }

    @Override
    public Order getOrderById(int id) {
        Session session = this.sessionFactory.openSession();
        Query<Order> query = session.createQuery("FROM thedinnerapp.model.Order WHERE id = :id");
        query.setParameter("id", id);
        Order order = query.getSingleResult();
        session.close();
        return order;
    }
}

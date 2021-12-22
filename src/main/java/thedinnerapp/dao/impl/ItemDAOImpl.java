package thedinnerapp.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import thedinnerapp.dao.IItemDAO;
import thedinnerapp.model.Item;

import javax.persistence.NoResultException;
import java.util.List;

@Repository
public class ItemDAOImpl implements IItemDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public ItemDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Item getItemById(int id) {
        Session session = this.sessionFactory.openSession();
        Query<Item> query = session.createQuery("FROM thedinnerapp.model.Item WHERE itemId=:id");
        query.setParameter("id", id);
        Item item = null;
        try {
            item = query.getSingleResult();
        } catch (NoResultException e) {
            System.out.println("Nie znaleziono przedmiotu! ");
        }
        session.close();
        return item;
    }

    @Override
    public List<Item> getItemsByRestaurantId(int id) {
        Session session = this.sessionFactory.openSession();
        Query<Item> query = session.createQuery("FROM thedinnerapp.model.Item WHERE restaurant.restaurantId=:id");
        query.setParameter("id", id);
        List<Item> items = query.getResultList();
        session.close();
        return items;

    }

    @Override
    public void removeItem(Item item) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.delete(item);
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
    public void updateItem(Item item) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(item);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) ;
            tx.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public void persistItem(Item item) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(item);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
    }
}

package thedinnerapp.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import thedinnerapp.dao.IRestaurantDAO;
import thedinnerapp.model.Restaurant;

import javax.persistence.NoResultException;
import java.util.List;

@Repository
public class RestaurantDAOImpl implements IRestaurantDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public RestaurantDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Restaurant getRestaurantById(int id) {
        Session session = this.sessionFactory.openSession();
        Query<Restaurant> query = session.createQuery("FROM thedinnerapp.model.Restaurant WHERE restaurantId=:id");
        query.setParameter("id", id);
        Restaurant restaurant = null;
        try {
            restaurant = query.getSingleResult();
        } catch (NoResultException e) {
            System.out.println("Nie znaleziono restauracji!");
        }
        session.close();
        return restaurant;
    }

    @Override
    public List<Restaurant> getAllRestaurants() {
        Session session = this.sessionFactory.openSession();
        Query<Restaurant> query = session.createQuery("FROM thedinnerapp.model.Restaurant");
        List<Restaurant> restaurants = query.getResultList();
        session.close();
        return restaurants;
    }

    @Override
    public List<Restaurant> getRestaurantsByCuisine(Restaurant.Cuisine cuisine) {
        Session session = this.sessionFactory.openSession();
        Query<Restaurant> query = session.createQuery("FROM thedinnerapp.model.Restaurant WHERE cuisine=:cuisine");
        query.setParameter("cuisine", cuisine);
        List<Restaurant> restaurants = query.getResultList();
        session.close();
        return restaurants;
    }

    @Override
    public void persistRestaurant(Restaurant restaurant) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(restaurant);
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
    public void updateRestaurant(Restaurant restaurant) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(restaurant);
            tx.commit();
        } catch (Exception e) {
            if (tx != null)
                tx.rollback();
        } finally {
            session.close();
        }

    }

    @Override
    public void removeRestaurant(Restaurant restaurant) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.delete(restaurant);
            tx.commit();
        } catch (Exception e) {
            if (tx != null)
                tx.rollback();
        } finally {
            session.close();
        }
    }
}

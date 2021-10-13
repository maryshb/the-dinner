package thedinnerapp.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import thedinnerapp.dao.IRestaurantDAO;
import thedinnerapp.model.Restaurant;

import javax.persistence.NoResultException;
import java.util.List;

@Repository
public class RestaurantDAOImpl implements IRestaurantDAO {

    @Autowired
    SessionFactory sessionFactory;


    @Override
    public Restaurant getRestaurantById(int id) {
        Session session = this.sessionFactory.openSession();
        Query<Restaurant> query = session.createQuery("FROM thedinnerapp.model.Restaurant WHERE id=:id");
        query.setParameter("id", id);
        Restaurant restaurant = null;
        try {
            restaurant = query.getSingleResult();
        } catch (NoResultException e ) {
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
}

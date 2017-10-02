package ua.com.lovelypresents.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.com.lovelypresents.model.CartItem;

/**
 * Created by Sofiia on 29.09.2017.
 */
@Repository
@Transactional
public class CartItemDao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addCartItem(CartItem cartItem) {
        Session session = this.sessionFactory.getCurrentSession();

        session.persist(cartItem);
    }
}

package ua.com.lovelypresents.dao.implementations.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.com.lovelypresents.dao.interfaces.CartItemDao;
import ua.com.lovelypresents.model.CartItem;

import java.util.List;

/**
 * Created by Sofiia on 29.09.2017.
 */
@Repository
@Transactional
public class CartItemDaoHiber implements CartItemDao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addCartItem(CartItem cartItem) {
        Session session = this.sessionFactory.getCurrentSession();

        session.persist(cartItem);
    }

    public List<CartItem> getCartByUserId(int userId) {
        Session session = this.sessionFactory.getCurrentSession();

        String hql = "from CartItem where userId = :userId";
        Query query = session.createQuery(hql);
        query.setParameter("userId", new Integer(userId));

        List<CartItem> cart = query.list();

        return cart;
    }
}

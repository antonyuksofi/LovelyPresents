package ua.com.lovelypresents.dao.implementations;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.com.lovelypresents.dao.interfaces.CartItemDao;
import ua.com.lovelypresents.model.CartItem;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;


@Repository
@Transactional
public class CartItemDaoImpl implements CartItemDao {

    @PersistenceContext
    private EntityManager em;

    public void addCartItem(CartItem cartItem) {

        em.persist(cartItem);
    }

    public List<CartItem> getCartByUserId(int userId) {

        String hql = "from CartItem where userId = :userId";
        Query query = em.createQuery(hql);
        query.setParameter("userId", new Integer(userId));

        List<CartItem> cart = query.getResultList();

        return cart;
    }
}

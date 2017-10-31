package ua.com.lovelypresents.dao.implementations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.com.lovelypresents.dao.interfaces.ProductDao;
import ua.com.lovelypresents.model.Product;

import java.util.List;

/**
 * Created by Sofiia on 14.09.2017.
 */
@Repository
@Transactional
public class ProductDaoImpl implements ProductDao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Product> getProducts() {
        Session session = this.sessionFactory.getCurrentSession();

        String hql = "from Product";
        Query query = session.createQuery(hql);

        List<Product> productsList = query.list();

        return productsList;
    }

    public List getProductsByCategory(int categoryId) {
        Session session = this.sessionFactory.getCurrentSession();

        String hql = "from Product where category_id = :category_id";
        Query query = session.createQuery(hql);
        query.setParameter("category_id", new Integer(categoryId));

        List<Product> productsList = query.list();

        return productsList;

    }

    public Product getProductByCode(String code) {
        Session session = this.sessionFactory.getCurrentSession();

        String hql = "from Product where code = :code";
        Query query = session.createQuery(hql);
        query.setParameter("code", code);

        Product result = (Product) query.getSingleResult();

        return result;
    }
}

package ua.com.lovelypresents.dao.implementations;

import javax.persistence.Query;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.com.lovelypresents.dao.interfaces.ProductDao;
import ua.com.lovelypresents.model.Product;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
@Transactional
public class ProductDaoImpl implements ProductDao {

    @PersistenceContext
    private EntityManager em;

    public List<Product> getProducts() {
        return (List<Product>) em.createQuery("SELECT p FROM Product p").getResultList();
    }

    public List getProductsByCategory(int categoryId) {
        String jpql = "from Product where categoryId = :categoryId";
        Query query = em.createQuery(jpql);
        query.setParameter("categoryId", new Integer(categoryId));

        List<Product> productsList = query.getResultList();

        return productsList;

    }

    public Product getProductByCode(String code) {
        String jpql = "from Product where code = :code";
        Query query = em.createQuery(jpql);
        query.setParameter("code", code);

        return (Product) query.getSingleResult();
    }
}

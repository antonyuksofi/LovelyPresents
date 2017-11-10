package ua.com.lovelypresents.dao.implementations.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.com.lovelypresents.dao.interfaces.CategoryDao;
import ua.com.lovelypresents.model.Category;

import java.util.List;

/**
 * Created by Sofiia on 19.09.2017.
 */
@Repository
@Transactional
public class CategoryDaoHiber implements CategoryDao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @SuppressWarnings("unchecked")
    public List<Category> getChildrenCategories(int parentCategoryId) {
        Session session = this.sessionFactory.getCurrentSession();

        String hql = "from Category where parentId = :parentId";
        Query query = session.createQuery(hql);
        query.setParameter("parentId", new Integer(parentCategoryId));

        List<Category> categoriesList = query.list();

        return categoriesList;
    }

    @SuppressWarnings("unchecked")
    public int getCategoryIdByCode(String categoryCode) {
        Session session = this.sessionFactory.getCurrentSession();

        String hql = "select id from Category where code = :categoryCode";
        Query query = session.createQuery(hql);
        query.setParameter("categoryCode", categoryCode);

        List<Integer> result = query.list();

        int categoryId;
        if (result.size() != 0)
            categoryId = result.get(0);
        else
            categoryId = 0;

        return categoryId;
    }

    @SuppressWarnings("unchecked")
    public boolean hasChildrenCategories(int categoryId) {
        Session session = this.sessionFactory.getCurrentSession();

        String hql = "select count(*) from Category where parentId = :categoryId";
        Query query = session.createQuery(hql);
        query.setParameter("categoryId", categoryId);

        int childrenAmount = ((Number)query.uniqueResult()).intValue();


        if (childrenAmount > 0)
            return true;
        else
            return false;
    }
}

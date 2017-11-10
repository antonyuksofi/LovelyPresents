package ua.com.lovelypresents.dao.implementations;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.com.lovelypresents.dao.interfaces.CategoryDao;
import ua.com.lovelypresents.model.Category;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;


@Repository
@Transactional
public class CategoryDaoImpl implements CategoryDao {

    @PersistenceContext
    private EntityManager em;


    @SuppressWarnings("unchecked")
    public List<Category> getChildrenCategories(int parentCategoryId) {

        String hql = "from Category where parentId = :parentId";
        Query query = em.createQuery(hql);
        query.setParameter("parentId", new Integer(parentCategoryId));

        List<Category> categoriesList = query.getResultList();

        return categoriesList;
    }

    @SuppressWarnings("unchecked")
    public int getCategoryIdByCode(String categoryCode) {

        String hql = "select id from Category where code = :categoryCode";
        Query query = em.createQuery(hql);
        query.setParameter("categoryCode", categoryCode);

        List<Integer> result = query.getResultList();

        int categoryId;
        if (result.size() != 0)
            categoryId = result.get(0);
        else
            categoryId = 0;

        return categoryId;
    }

    @SuppressWarnings("unchecked")
    public boolean hasChildrenCategories(int categoryId) {

        String hql = "select count(*) from Category where parentId = :categoryId";
        Query query = em.createQuery(hql);
        query.setParameter("categoryId", categoryId);

        int childrenAmount = ((Number)query.getSingleResult()).intValue();


        if (childrenAmount > 0)
            return true;
        else
            return false;
    }
}

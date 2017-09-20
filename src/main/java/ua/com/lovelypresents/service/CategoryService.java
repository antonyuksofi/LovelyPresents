package ua.com.lovelypresents.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.lovelypresents.dao.CategoryDao;
import ua.com.lovelypresents.dao.ProductDao;
import ua.com.lovelypresents.model.Category;

import java.util.List;

/**
 * Created by Sofiia on 19.09.2017.
 */
@Service
public class CategoryService {

    @Autowired
    CategoryDao categoryDao;

    @Autowired
    ProductDao productDao;

    public List<Category> getChildrenCategories(int parentCategoryId) {
        return categoryDao.getChildrenCategories(parentCategoryId);
    }

    public List getChildrenCategoriesOrProducts(String parentCategoryCode) {
        int parentCategoryId = categoryDao.getCategoryIdByCode(parentCategoryCode);

        if (categoryDao.hasChildrenCategories(parentCategoryId))
            return this.getChildrenCategories(parentCategoryId);
        else
            return this.getChildrenProducts(parentCategoryId);
    }

    public List getChildrenProducts(int categoryId) {
        return productDao.getProductsByCategory(categoryId);
    }
}

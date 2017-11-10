package ua.com.lovelypresents.service.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.lovelypresents.dao.interfaces.CategoryDao;
import ua.com.lovelypresents.dao.interfaces.ProductDao;
import ua.com.lovelypresents.model.Category;
import ua.com.lovelypresents.service.interfaces.CategoryService;

import java.util.List;


@Service
public class CategoryServiceImpl implements CategoryService {

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

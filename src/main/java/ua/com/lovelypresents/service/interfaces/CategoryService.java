package ua.com.lovelypresents.service.interfaces;

import ua.com.lovelypresents.model.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getChildrenCategories(int parentCategoryId);

    List getChildrenCategoriesOrProducts(String parentCategoryCode);

    List getChildrenProducts(int categoryId);
}

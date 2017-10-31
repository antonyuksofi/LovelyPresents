package ua.com.lovelypresents.dao.interfaces;
import ua.com.lovelypresents.model.Category;

import java.util.List;

public interface CategoryDao {

    List<Category> getChildrenCategories(int parentCategoryId);

    int getCategoryIdByCode(String categoryCode);

    boolean hasChildrenCategories(int categoryId);
}

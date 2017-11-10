package ua.com.lovelypresents.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ua.com.lovelypresents.model.Category;
import ua.com.lovelypresents.service.interfaces.CategoryService;

import java.util.List;


@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;


    /**
     * Gets categories of the highest (root) level.
     * @return list of root categories
     */
    @RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Category> getMainCategories() {
        return categoryService.getChildrenCategories(0);
    }


    /**
     * Gets children categories for non-leaf category and products for leaf category.
     * @param categoryName name of category whose children are to be returned
     * @return list of children categories for non-leaf category or products for leaf category
     */
    @RequestMapping(value = "/{categoryName}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List getChildrenCategoriesOrProducts(@PathVariable String categoryName) {
        return categoryService.getChildrenCategoriesOrProducts(categoryName);
    }
}

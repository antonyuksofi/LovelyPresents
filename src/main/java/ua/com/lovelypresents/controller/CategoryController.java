package ua.com.lovelypresents.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ua.com.lovelypresents.model.Category;
import ua.com.lovelypresents.service.CategoryService;

import java.util.List;

/**
 * Created by Sofiia on 19.09.2017.
 */

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;


    @RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Category> getMainCategories() {
        return categoryService.getChildrenCategories(0);
    }


    @RequestMapping(value = "/{categoryName}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List getChildrenCategoriesOrProducts(@PathVariable String categoryName) {
        return categoryService.getChildrenCategoriesOrProducts(categoryName);
    }
}

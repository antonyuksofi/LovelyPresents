package ua.com.lovelypresents.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ua.com.lovelypresents.model.Product;
import ua.com.lovelypresents.service.interfaces.ProductService;

import java.util.List;

/**
 * Created by Sofiia on 14.09.2017.
 */
@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    /**
     * Gets all products.
     * @return list of all products
     */
    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    /**
     * Gets product by its code
     * @param productCode code of product to retrieve
     * @return product with this particular product code
     */
    @RequestMapping(value = "/{productCode}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Product getProductByCode(@PathVariable String productCode) {
        return productService.getProductByCode(productCode);
    }
}

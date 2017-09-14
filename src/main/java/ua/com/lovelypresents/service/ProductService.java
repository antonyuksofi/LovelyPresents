package ua.com.lovelypresents.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.lovelypresents.dao.ProductDao;
import ua.com.lovelypresents.model.Product;

import java.util.List;

/**
 * Created by Sofiia on 14.09.2017.
 */
@Service
public class ProductService {

    @Autowired
    private ProductDao productDao;

    public List<Product> getProducts() {
        return productDao.getProducts();
    }

    public Product getProduct() {
        return productDao.getProduct();
    }
}

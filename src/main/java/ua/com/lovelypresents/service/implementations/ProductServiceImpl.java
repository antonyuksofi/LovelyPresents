package ua.com.lovelypresents.service.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.lovelypresents.dao.interfaces.ProductDao;
import ua.com.lovelypresents.model.Product;
import ua.com.lovelypresents.service.interfaces.ProductService;

import java.util.List;

/**
 * Created by Sofiia on 14.09.2017.
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    public List<Product> getProducts() {
        return productDao.getProducts();
    }

    public List<Product> getProductsByCategory(int categoryId) {
        return productDao.getProductsByCategory(categoryId);
    }

    public Product getProductByCode(String code) {
        return productDao.getProductByCode(code);
    }
}

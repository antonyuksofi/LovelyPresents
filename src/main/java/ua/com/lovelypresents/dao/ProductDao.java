package ua.com.lovelypresents.dao;

import org.springframework.stereotype.Repository;
import ua.com.lovelypresents.model.Product;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Sofiia on 14.09.2017.
 */
@Repository
public class ProductDao {

    private List<Product> testProds = Arrays.asList(
            new Product(1, "чашка", "cup"),
            new Product(2, "футболка", "shirt")
    );

    public List<Product> getProducts() {
        return testProds;
    }

    public Product getProduct() {
        return testProds.get(0);
    }
}

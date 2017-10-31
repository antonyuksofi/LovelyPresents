package ua.com.lovelypresents.dao.interfaces;
import ua.com.lovelypresents.model.Product;

import java.util.List;

public interface ProductDao {

    List<Product> getProducts();

    List getProductsByCategory(int categoryId);

    Product getProductByCode(String code);
}

package ua.com.lovelypresents.service.interfaces;

import ua.com.lovelypresents.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getProducts();

    List<Product> getProductsByCategory(int categoryId);

    Product getProductByCode(String code);
}

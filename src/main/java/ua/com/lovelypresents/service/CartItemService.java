package ua.com.lovelypresents.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import ua.com.lovelypresents.dao.CartItemDao;
import ua.com.lovelypresents.model.CartItem;

import java.util.List;

/**
 * Created by Sofiia on 29.09.2017.
 */
@Service
public class CartItemService {

    @Autowired
    CartItemDao cartItemDao;

    public void addCartItem(MultiValueMap formMap) {
        CartItem cartItem = this.fromMapToCartItem(formMap);

        cartItemDao.addCartItem(cartItem);
    }

    private CartItem fromMapToCartItem(MultiValueMap<String, String> formMap) {
        CartItem cartItem = new CartItem();

        cartItem.setUser_id(Integer.parseInt(formMap.get("user_id").get(0)));
        cartItem.setProduct_id(Integer.parseInt(formMap.get("product_id").get(0)));
        cartItem.setImage(formMap.get("image").get(0));
        cartItem.setCount(Integer.parseInt(formMap.get("count").get(0)));

        return cartItem;
    }

    public List<CartItem> getCartByUserId(int userId) {
        List<CartItem> cart = cartItemDao.getCartByUserId(userId);

        return cart;
    }
}

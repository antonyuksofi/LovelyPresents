package ua.com.lovelypresents.service.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import ua.com.lovelypresents.dao.interfaces.CartItemDao;
import ua.com.lovelypresents.model.CartItem;
import ua.com.lovelypresents.service.interfaces.CartItemService;

import java.util.List;


@Service
public class CartItemServiceImpl implements CartItemService {

    @Autowired
    CartItemDao cartItemDao;

    public void addCartItem(MultiValueMap formMap) {
        CartItem cartItem = this.fromMapToCartItem(formMap);

        cartItemDao.addCartItem(cartItem);
    }

    private CartItem fromMapToCartItem(MultiValueMap<String, String> formMap) {
        CartItem cartItem = new CartItem();

        cartItem.setUserId(Integer.parseInt(formMap.get("userId").get(0)));
        cartItem.setProductId(Integer.parseInt(formMap.get("productId").get(0)));
        cartItem.setImage(formMap.get("image").get(0));
        cartItem.setCount(Integer.parseInt(formMap.get("count").get(0)));

        return cartItem;
    }

    public List<CartItem> getCartByUserId(int userId) {
        List<CartItem> cart = cartItemDao.getCartByUserId(userId);

        return cart;
    }
}

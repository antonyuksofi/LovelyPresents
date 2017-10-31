package ua.com.lovelypresents.dao.interfaces;
import ua.com.lovelypresents.model.CartItem;

import java.util.List;

public interface CartItemDao {

    void addCartItem(CartItem cartItem);

    List<CartItem> getCartByUserId(int userId);
}

package ua.com.lovelypresents.service.interfaces;

import org.springframework.util.MultiValueMap;
import ua.com.lovelypresents.model.CartItem;

import java.util.List;

public interface CartItemService {

    void addCartItem(MultiValueMap formMap);

    List<CartItem> getCartByUserId(int userId);
}

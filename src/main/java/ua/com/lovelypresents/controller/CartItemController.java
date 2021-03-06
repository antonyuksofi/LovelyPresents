package ua.com.lovelypresents.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import ua.com.lovelypresents.model.CartItem;
import ua.com.lovelypresents.service.interfaces.CartItemService;

import java.util.List;


@Controller
@RequestMapping("/cart")
public class CartItemController {

    @Autowired
    private CartItemService cartItemService;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String cartFilling() {
        return "cart_filling";
    }


    /**
     * Adds the product to the cart based on ordinary form fields
     * @param formMap map from which product data is extracted
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void addCartItem(@RequestBody MultiValueMap<String, String> formMap) {
        cartItemService.addCartItem(formMap);
    }


    /**
     * Shows the cart content for the user by id
     * @param userId id of user whose cart is to be shown
     * @return list of CartItems in the cart
     * @see CartItem
     */
    @RequestMapping(value = "/show", method = RequestMethod.GET)
    @ResponseBody
    public List<CartItem> showCart(@RequestParam int userId) {
        List<CartItem> cart = cartItemService.getCartByUserId(userId);

        return cart;
    }
}

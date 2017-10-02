package ua.com.lovelypresents.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import ua.com.lovelypresents.model.CartItem;
import ua.com.lovelypresents.service.CartItemService;

import java.util.Map;

/**
 * Created by Sofiia on 29.09.2017.
 */
@Controller
@RequestMapping("/cart")
public class CartItemController {

    @Autowired
    CartItemService cartItemService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void addCartItem(@RequestBody MultiValueMap<String, String> formMap) {
        cartItemService.addCartItem(formMap);
    }
}

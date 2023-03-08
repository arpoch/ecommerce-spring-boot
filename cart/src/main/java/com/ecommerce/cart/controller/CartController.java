package com.ecommerce.cart.controller;

import com.ecommerce.cart.entity.Item;
import com.ecommerce.cart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    CartService cartService;

    @PostMapping("/add-item")
    public Item addItem(@RequestBody Item item){
        return cartService.addItemToCart(item);
    }

    @PutMapping("update-quantity/{code}/{quantity}")
    public String updateItemQuantity(@PathVariable(name = "code") String code, @PathVariable(name = "quantity") int quantity){
        return cartService.updateCartItem(code,quantity);
    }
    @DeleteMapping("/remove-item/{code}")
    public void removeItem(@PathVariable(name = "code") String code){
        cartService.deleteCartItem(code);
    }

    @GetMapping("/show-items")
    public List<Item> listItems(){
        return cartService.showCartItems();
    }

}

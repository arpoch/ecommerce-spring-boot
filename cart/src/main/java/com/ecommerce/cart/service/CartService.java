package com.ecommerce.cart.service;

import com.ecommerce.cart.entity.Item;
import com.ecommerce.cart.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    @Autowired
    CartRepository cartRepository;

    public void deleteCartItem(String code) {
        cartRepository.deleteById(code);
    }

    public List<Item> showCartItems() {
        return (List<Item>) cartRepository.findAll();
    }

    public Item addItemToCart(Item item) {
        return cartRepository.save(item);
    }

    //To update the item quantity in cart, the user will be redirected to catalog page
    //The item quantity can only be updated by Catalog API
    public String updateCartItem(String code, int quantity) {
        Optional<Item> item = cartRepository.findById(code);
        if(item.isPresent()){
            item.get().setQuantity(quantity);
            cartRepository.save(item.get());
            return "Cart Item Updated";
        }
        return "Item not found in cart";
    }
}

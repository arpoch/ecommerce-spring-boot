package com.ecommerce.catalog.controller;

import com.ecommerce.catalog.entity.Item;
import com.ecommerce.catalog.service.ItemService;
import com.ecommerce.catalog.service.ZeroQuantityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/catalog")
public class ItemController {
    @Autowired
    ItemService itemService;

    @PostMapping("/add-item/{code}")
    public Item addItem(@PathVariable(name = "code") String code) {
        try {
            return itemService.addItemToCart(code);
        }catch (ZeroQuantityException e){
            System.out.println(e.getMessage());
            return new Item("E04","Item Not Added",0,0);
        }
    }

    @PutMapping("/update-quantity/{code}/{quantity}")
    public String updateItemQuantity(@PathVariable(name = "code") String code, @PathVariable(name = "quantity") int quantity) {
         return itemService.updateItemQuantity(code,quantity);
    }

    @GetMapping("/show-item")
    public List<Item> listCatalog(){ return itemService.showAllItems(); }

}

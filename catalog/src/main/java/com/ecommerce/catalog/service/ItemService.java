package com.ecommerce.catalog.service;

import com.ecommerce.catalog.entity.Item;
import com.ecommerce.catalog.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {
    @Autowired
    ItemRepository itemRepository;

    @Autowired
    RestTemplate restTemplate;

    public Item addItemToCart(String code) throws ZeroQuantityException {
        String URL = "http://CART/cart/add-item";
        Item item = itemRepository.findByCode(code);
        if(item!=null && item.getQuantity()>0) {
            ResponseEntity<Item> entity = restTemplate.exchange(
                            URL,
                            HttpMethod.POST,
                            new HttpEntity<>(item),
                            Item.class);
            return entity.getBody();
        }else{
            throw new ZeroQuantityException("The quantity is zero or less than zero");
        }
    }

    public String updateItemQuantity(String code,int quantity){

        String URL = "http://CART/cart/update-quantity/"+code+"/"+quantity;
        ResponseEntity<String> entity = restTemplate.exchange(
                URL,
                HttpMethod.PUT,
                null,
                String.class);

        Item item = itemRepository.findByCode(code);
        if(item!=null){
            item.setQuantity(quantity);
            itemRepository.save(item);
            return "Catalog item updated\n" + entity.getBody();
        }else{
            return "Item not found in catalog\n" + entity.getBody();
        }
    }

    public List<Item> showAllItems(){
        return itemRepository.findAll();
    }
}

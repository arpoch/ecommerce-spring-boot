package com.ecommerce.cart.repository;

import com.ecommerce.cart.entity.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends CrudRepository<Item,String> {
}

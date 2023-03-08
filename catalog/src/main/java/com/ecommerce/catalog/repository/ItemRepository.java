package com.ecommerce.catalog.repository;

import com.ecommerce.catalog.entity.Item;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ItemRepository extends CrudRepository<Item,String> {

    Item findByCode(String code);

    String findNameByCode(String code);

    List<Item> findAll();
}

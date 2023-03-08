package com.ecommerce.catalog.entity;

//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.Id;
//import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//POJO
@Entity
@Table(name = "Catalog")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    @Id
    @Column(name = "code")
    private String code;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private int price;
    @Column(name = "quantity")
    private int quantity;
}
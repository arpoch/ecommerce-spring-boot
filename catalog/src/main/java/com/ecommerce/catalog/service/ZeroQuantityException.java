package com.ecommerce.catalog.service;

public class ZeroQuantityException extends Exception{
    public ZeroQuantityException(String message) {
        super(message);
    }
}

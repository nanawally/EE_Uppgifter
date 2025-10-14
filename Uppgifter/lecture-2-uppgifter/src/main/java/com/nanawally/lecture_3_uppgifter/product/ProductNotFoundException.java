package com.nanawally.lecture_3_uppgifter.product;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(String message) {
        super("Product could not be found: " + message);
    }
}

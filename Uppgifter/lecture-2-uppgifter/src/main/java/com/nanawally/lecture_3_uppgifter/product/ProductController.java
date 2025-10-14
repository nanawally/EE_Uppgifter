package com.nanawally.lecture_3_uppgifter.product;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<Product> getProductByName(@RequestParam String name) {
        return ResponseEntity.ok().body(productService.findByName(name));
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(
            @Valid @RequestBody Product product
    ) {
        return ResponseEntity.ok().body(productService.createProduct(product));
    }

}

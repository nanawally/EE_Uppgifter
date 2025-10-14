package com.nanawally.lecture_3_uppgifter.product;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;

@Entity
@Table(name = "Products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    @Size(min = 2, max = 255, message = "Name must be min 2 chars")
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull
    //@DecimalMin(value = "0.01", inclusive = true, message = "Price must be at least 0.01")
    @PositiveOrZero // Hej Kristoffer, can I use this instead of @DecimalMin?
    @Column(name = "price", nullable = false)
    private BigDecimal price;

    public Product(Long id, String name, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Product() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}

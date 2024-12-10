package org.example.onlineshop.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String imageURL;
    @Column(nullable = false)
    private String product_name;
    @Column(nullable = false, unique = true)
    private String product_category;
    @Column(nullable = false)
    private String product_brand;
    @Column(nullable = false)
    private String product_description;
    @Column(nullable = false)
    private double product_price;
    @Column(nullable = false)
    private Integer quantity;
}

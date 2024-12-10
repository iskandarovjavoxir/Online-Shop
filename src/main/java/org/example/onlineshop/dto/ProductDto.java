package org.example.onlineshop.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDto {
    private String imageURL;
    private String product_name;
    private String product_category;
    private String product_brand;
    private String product_description;
    private double product_price;

}

package org.example.onlineshop.service;

import org.example.onlineshop.dto.ProductDto;
import org.example.onlineshop.model.Product;
import org.example.onlineshop.model.Result;
import org.example.onlineshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    //CREATE
    public Result addProduct(ProductDto productDto) {
        Product product = new Product();
        product.setImageURL(productDto.getImageURL());
        product.setProduct_name(productDto.getProduct_name());
        product.setProduct_category(productDto.getProduct_category());
        product.setProduct_brand(productDto.getProduct_brand());
        product.setProduct_description(productDto.getProduct_description());
        product.setProduct_price(productDto.getProduct_price());
        productRepository.save(product);
        return new Result(true,"Successfully added product");
    }


}

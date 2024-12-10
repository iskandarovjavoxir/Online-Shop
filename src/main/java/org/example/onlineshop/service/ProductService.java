package org.example.onlineshop.service;

import org.example.onlineshop.dto.ProductDto;
import org.example.onlineshop.model.Product;
import org.example.onlineshop.model.Result;
import org.example.onlineshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    //READ All
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    //READ By ID
    public Product getProductById(Long id) {
        return productRepository.findById(id).get();
    }

    //UPDATE
    public Result editProduct(Long id,ProductDto productDto) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if(optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            product.setImageURL(productDto.getImageURL());
            product.setProduct_name(productDto.getProduct_name());
            product.setProduct_category(productDto.getProduct_category());
            product.setProduct_brand(productDto.getProduct_brand());
            product.setProduct_description(productDto.getProduct_description());
            product.setProduct_price(productDto.getProduct_price());
            productRepository.save(product);
            return new Result(true,"Successfully updated product");
        }
        return new Result(false,"Product not found");
    }

    //DELETE
    public Result deleteProduct(Long id) {
        productRepository.deleteById(id);
        return new Result(true,"Successfully deleted product");
    }
}

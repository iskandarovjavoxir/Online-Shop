package org.example.onlineshop.controller;

import org.example.onlineshop.dto.ProductDto;
import org.example.onlineshop.model.Product;
import org.example.onlineshop.model.Result;
import org.example.onlineshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    //CREATE
    @PostMapping()
    public Result addProduct(@RequestBody ProductDto productDto) {
        return productService.addProduct(productDto);
    }

    //READ All
    @GetMapping()
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    //READ By Id
    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    //UPDATE
    @PutMapping("/{id}")
    public Result editProduct(@PathVariable Long id, @RequestBody ProductDto productDto) {
        return productService.editProduct(id, productDto);
    }

    //DELETE
    @DeleteMapping("/{id}")
    public Result deleteProduct(@PathVariable Long id) {
        return productService.deleteProduct(id);
    }
}

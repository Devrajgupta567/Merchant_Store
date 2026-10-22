package com.devraj.merchant_store.controllers;

import com.devraj.merchant_store.entitites.OrderItem;
import com.devraj.merchant_store.entitites.Product;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( "/api/products")

public class ProductController {

    @PostMapping
    public Product createProduct(@Valid @RequestBody Product product){

        return null;
    }


    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id,@Valid @RequestBody Product product){
        return null;
    }

    @GetMapping
    public  List<Product> getProducts(Long id){
            return null;
    }

    @GetMapping("/{id}")
   public Product getProductById(@PathVariable Long id){
        return null;
   }


   @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable  Long id){

    }

}

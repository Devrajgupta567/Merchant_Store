package com.devraj.merchant_store.services;

import com.devraj.merchant_store.entitites.Product;

import com.devraj.merchant_store.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
@RequiredArgsConstructor

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public Product createProduct(Product product){

        return  productRepository.save(product);
    }

    public Product updateProduct( Long id,  Product product){

        Product existingProduct = productRepository.findById(id)
                .orElseThrow(()->new RuntimeException("product not found with id "+id));
        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setCategory(product.getCategory());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setStockQuantity(product.getStockQuantity());

        return productRepository.save(existingProduct);
    }


    public List<Product> getProducts(Long id){

        return productRepository.findAll();
    }


    public Product getProductById(Long id){

        return  productRepository.findById(id)
                .orElseThrow(()->new RuntimeException("product not found with id "+id));

    }

    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }

}

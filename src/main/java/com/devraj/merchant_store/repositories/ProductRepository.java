package com.devraj.merchant_store.repositories;

import com.devraj.merchant_store.entitites.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository  extends JpaRepository<Product, Long> {

}

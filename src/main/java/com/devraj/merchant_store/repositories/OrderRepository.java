package com.devraj.merchant_store.repositories;

import com.devraj.merchant_store.entitites.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {

}

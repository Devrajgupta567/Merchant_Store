package com.devraj.merchant_store.repositories;

import com.devraj.merchant_store.entitites.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository  extends JpaRepository<OrderItem,Long> {

}

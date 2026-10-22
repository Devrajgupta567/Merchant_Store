package com.devraj.merchant_store.services;

import com.devraj.merchant_store.dto.OrderItemRequest;
import com.devraj.merchant_store.dto.OrderRequest;
import com.devraj.merchant_store.entitites.Order;
import com.devraj.merchant_store.entitites.OrderItem;
import com.devraj.merchant_store.entitites.Product;
import com.devraj.merchant_store.repositories.OrderRepository;
import com.devraj.merchant_store.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    @Transactional
    public Order createOrder(OrderRequest orderRequest){

        BigDecimal totalPrice = BigDecimal.ZERO;

        List<OrderItem> orderItems = new ArrayList<>();

        Order order = new Order();
        order.setCustomerName(orderRequest.getCustomerName());
        order.setCustomerEmail(orderRequest.getCustomerEmail());
        order.setStatus("CONFIRMED");

        for(OrderItemRequest itemRequest : orderRequest.getItems()){
            Product product = productRepository.findById(
                    itemRequest.getProductId()
            ).orElseThrow(()->new RuntimeException("Product not found with id " + itemRequest.getProductId()
            ));

            //Check the product stock

            if(product.getStockQuantity()<itemRequest.getQuantity()){
                throw new RuntimeException("Not Enough Stock for "+itemRequest.getProductId());
            }
            //calculate total price
            BigDecimal priceofItem=product.getPrice()
                    .multiply(new BigDecimal(itemRequest.getQuantity()));


            totalPrice=totalPrice.add(priceofItem);

            //Update the product table with latest stock quantity
            product.setStockQuantity(product.getStockQuantity()-itemRequest.getQuantity());
            productRepository.save(product);

            //Builder Pattern to make obj
            OrderItem orderItem = OrderItem.builder()
                    .order(order)
                    .product(product)
                    .quantity(itemRequest.getQuantity())
                    .priceAtPurchase(product.getPrice())
                    .build();

            orderItems.add(orderItem);

        }

        order.setTotalPrice(totalPrice);
        order.setOrderItems(orderItems);

        return  orderRepository.save(order);
    }

}


package com.devraj.merchant_store.entitites;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import  java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
@Table(name="order_items")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder


public class OrderItem{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Quantity is Required ")
    @Min(value = 1, message = "Quantity must be at least 1")
    @Column(nullable=false)
    private Integer quantity;

    @NotNull(message = "Price At Purchase is Required ")
    @DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than zero")
    @Column(name="price_at_purchase" ,nullable=false)
    private  BigDecimal priceAtPurchase;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "order_id"  , nullable = false )
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false )
    private Product product;

}



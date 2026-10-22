package com.devraj.merchant_store.entitites;

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
import java.util.List;


@Entity
@Table(name="orders")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Customer Name is Required ")
    @Column(name="customer_name" ,nullable=false)
    private  String customerName;

    @NotBlank(message = "Customer Email is Reqired")
    @Column(name="customer_email" ,nullable=false)
    private  String customerEmail;


    @Column(nullable=false)
    private String status;


    @NotNull(message = "Price is Required")
    @DecimalMin(value="0.0" , inclusive=false , message="Price must be greater than zero" )
    @Column(name="total_price",nullable=false)
    private BigDecimal totalPrice;


    @JsonManagedReference
    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL)
    private List<OrderItem> orderItems;


    @Column(name="created_at")
    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist(){
        this.createdAt = LocalDateTime.now();
    }


}

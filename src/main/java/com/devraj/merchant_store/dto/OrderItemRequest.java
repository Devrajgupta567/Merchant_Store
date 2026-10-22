package com.devraj.merchant_store.dto;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderItemRequest  {

    @NotNull(message = "Product id is required")
    private Long productId;

    @NotNull(message = "Product quantity is required")
    @Min(value=1,message="Quantity must be  1")
    private Integer quantity;


}

package com.devraj.merchant_store.dto;


import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderRequest {

    @NotBlank(message = "Customer Name is Required")
    private String customerName;

    @NotBlank(message = "Customer Email is Required")
    @Email(message = "Enter a valid Email")
    private String customerEmail;

    @Valid
    @NotEmpty(message = "Oder must contain at least one item")
    private List<OrderItemRequest> items;
}

package com.example.springrabbitmq.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @JsonProperty("order_id")
    private String orderId;

    @JsonProperty("name")
    private String name;

    @JsonProperty("restaurant_name")
    private String restaurantName;

    @JsonProperty("quantity")
    private int quantity;

    @JsonProperty("price")
    private double price;
}

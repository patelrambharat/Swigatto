package com.example.Swigatto.dto.responce;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CartResponse {
    int cartTotal;

    List<FoodResponse> foodItems;
}

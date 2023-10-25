package com.example.Swigatto.dto.responce;

import com.example.Swigatto.Enum.FoodCategory;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FoodResponse {
    String dishName;

    double price;

    FoodCategory category;

    boolean veg;
}

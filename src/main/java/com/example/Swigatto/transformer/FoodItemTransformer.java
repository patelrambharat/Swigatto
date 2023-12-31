package com.example.Swigatto.transformer;


import com.example.Swigatto.dto.request.FoodRequest;
import com.example.Swigatto.dto.responce.FoodResponse;
import com.example.Swigatto.model.FoodItem;

public class FoodItemTransformer {
    public static FoodItem FoodRequestToFoodItem(FoodRequest foodRequest){
        return FoodItem.builder()
                .dishName(foodRequest.getDishName())
                .price(foodRequest.getPrice())
                .category(foodRequest.getCategory())
                .veg(foodRequest.isVeg())
                .available(foodRequest.isAvailable())
                .build();
    }

    public static FoodResponse FoodItemToFoodResponse(FoodItem foodItem){
        return FoodResponse.builder()
                .dishName(foodItem.getDishName())
                .price(foodItem.getPrice())
                .veg(foodItem.isVeg())
                .category(foodItem.getCategory())
                .build();
    }
}
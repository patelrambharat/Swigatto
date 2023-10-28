package com.example.Swigatto.utils;

import com.example.Swigatto.model.Restaurant;
import com.example.Swigatto.repository.RestaurantRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component   //to create the bean of the same class
public class ValidationUtils {

    final RestaurantRespository restaurantRespository;

    @Autowired
    public ValidationUtils(RestaurantRespository restaurantRespository) {
        this.restaurantRespository = restaurantRespository;
    }

    public boolean validateRestaurantId(int id){

        Optional<Restaurant> restaurantOptional = restaurantRespository.findById(id);
        return restaurantOptional.isPresent();
    }
}

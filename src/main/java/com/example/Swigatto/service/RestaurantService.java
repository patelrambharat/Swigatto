package com.example.Swigatto.service;


import com.example.Swigatto.dto.request.FoodRequest;
import com.example.Swigatto.dto.request.RestaurantRequest;
import com.example.Swigatto.dto.responce.RestaurantResponse;
import com.example.Swigatto.exception.RestaurantNotFoundException;

import com.example.Swigatto.model.FoodItem;
import com.example.Swigatto.model.Restaurant;
import com.example.Swigatto.repository.RestaurantRespository;

import com.example.Swigatto.transformer.FoodItemTransformer;
import com.example.Swigatto.transformer.RestaurantTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.ValidationUtils;


@Service
public class RestaurantService {


    final RestaurantRespository restaurantRespository;
   
    final ValidationUtils validationUtils;


    @Autowired
    public RestaurantService(RestaurantRespository restaurantRespository,
                             ValidationUtils validationUtils) {
        this.restaurantRespository = restaurantRespository;
        this.validationUtils = validationUtils;
    }

    public RestaurantResponse addRestaurant(RestaurantRequest restaurantRequest) {

        // dto -> model
        Restaurant restaurant = RestaurantTransformer.RestaurantRequestToRestaurant(restaurantRequest);
        //persist/save the model in db
        Restaurant savedRestaurant = restaurantRespository.save(restaurant);
        // prepare response dto from model
        return RestaurantTransformer.RestaurantToRestaurantResponse(savedRestaurant);
    }

    public String changeOpenedStatus(int id) {

        //check whether id is valid or not
        if(validationUtils.validateRestaurantId(id)){
            throw new RestaurantNotFoundException("Restaurant doesn't exist!!");
        }

        Restaurant restaurant = restaurantRespository.findById(id).get();
        restaurant.setOpened(!restaurant.isOpened());
        restaurantRespository.save(restaurant);

        if(restaurant.isOpened()){
            return "Restaurant is opened now!!!";
        }

        return "Restaurant is closed";
    }

    public RestaurantResponse addFoodItemtToRestaurant(FoodRequest foodRequest) {

        // check reataurant is valid or not
        if(!validationUtils.validateRestaurantId(foodRequest.getRestaurantId())){
            throw new RestaurantNotFoundException("Restaurant doesn't exist!!");
        }

        Restaurant restaurant = restaurantRespository.findById(foodRequest.getRestaurantId()).get();
        // make food entity
        FoodItem foodItem = FoodItemTransformer.FoodRequestToFoodItem(foodRequest);
        foodItem.setRestaurant(restaurant);

        restaurant.getAvailableFoodItems().add(foodItem);

        // save rest and food
        Restaurant savedRestaurant = restaurantRespository.save(restaurant);

        // prepare response
        return RestaurantTransformer.RestaurantToRestaurantResponse(savedRestaurant);

    }
}
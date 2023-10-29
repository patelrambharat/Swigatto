package com.example.Swigatto.controller;

import com.example.Swigatto.dto.request.FoodRequest;
import com.example.Swigatto.dto.request.RestaurantRequest;
import com.example.Swigatto.dto.responce.RestaurantResponse;
import com.example.Swigatto.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    final RestaurantService restaurantService;

    /**
     * Constructor Injection
     * @param restaurantService  --> bean of restaurant Service
     */
    @Autowired
    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @PostMapping("/add")
    public ResponseEntity addRestaurant(@RequestBody RestaurantRequest restaurantRequest){
        RestaurantResponse restaurantResponse = restaurantService.addRestaurant(restaurantRequest);
        return new ResponseEntity(restaurantResponse, HttpStatus.CREATED);
    }


    @PutMapping("/update/status")
    public ResponseEntity changeOpenedStatus(@RequestParam int id){
        String message = restaurantService.changeOpenedStatus(id);
        return new ResponseEntity(message,HttpStatus.ACCEPTED);
    }


    @PostMapping("/add/food")
    public ResponseEntity addFoodItemtToRestaurant(@RequestBody FoodRequest foodRequest){
        RestaurantResponse restaurantResponse = restaurantService.addFoodItemtToRestaurant(foodRequest);
        return new ResponseEntity(restaurantResponse,HttpStatus.CREATED);
    }

    // get menu of a restaurant
}
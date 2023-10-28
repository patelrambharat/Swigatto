package com.example.Swigatto.exception;

public class RestaurantNotFoundException extends RuntimeException{
    public RestaurantNotFoundException(String message){
        super(message);
    }
}

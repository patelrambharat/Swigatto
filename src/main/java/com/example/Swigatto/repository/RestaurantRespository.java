package com.example.Swigatto.repository;

import com.example.Swigatto.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRespository extends JpaRepository<Restaurant,Integer> {

}
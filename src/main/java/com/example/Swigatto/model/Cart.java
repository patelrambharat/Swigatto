package com.example.Swigatto.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Builder
//@ data will use @setter , @getter , @toString , @requiredargs
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    int cartTotal;
    @OneToOne
    @JoinColumn
    Customer customer;
    @OneToMany(mappedBy = "cart",cascade = CascadeType.ALL)
    List<FoodItem> foodItems = new ArrayList<>();

}

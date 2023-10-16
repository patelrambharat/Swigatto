package com.example.Swigatto.model;

import com.example.Swigatto.Enum.FoodCategory;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Builder
//@ data will use @setter , @getter , @toString , @requiredargs
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "fooditem")
public class FoodItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String dishName;

    double price;

    @Enumerated(EnumType.STRING)
    FoodCategory category;

    boolean veg;

    boolean available;
}

package com.example.Swigatto.model;

import com.example.Swigatto.Enum.RestarauntCategory;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Builder
//@ data will use @setter , @getter , @toString , @requiredargs
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "restaurant")
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name;

    String location;

    RestarauntCategory restrauntCategory;

    @Column(unique = true,nullable = false)
    @Size(min = 10, max = 10)
    String contactNumber;

    boolean opened;
}

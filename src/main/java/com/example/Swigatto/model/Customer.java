package com.example.Swigatto.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
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
@Table(name= "customer")  //to identify the table
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name;

    @Email
    @Column(unique = true)
    String email;

    String address;

    @Column(unique = true,nullable = false)
    @Size(min = 10, max = 10)
    String mobileNo;
    



}

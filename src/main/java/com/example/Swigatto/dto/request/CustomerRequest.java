package com.example.Swigatto.dto.request;


import com.example.Swigatto.Enum.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRequest {
    String name;

    String email;

    String address;

    String mobileNo;

    Gender gender;

}

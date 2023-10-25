package com.example.Swigatto.dto.responce;

import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerResponse {
    String name;

    String mobileNo;

    String address;

    CartResponse cart;
}

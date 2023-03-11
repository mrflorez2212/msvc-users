package com.marco.springcloud.msvc.users.msvcusers.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO {
    private String city;
    private String address;
    private int number;
    private String zipcode;
}

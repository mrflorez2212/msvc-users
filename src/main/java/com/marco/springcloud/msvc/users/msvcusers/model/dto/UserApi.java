package com.marco.springcloud.msvc.users.msvcusers.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserApi {
    private int id;
    private String email;
    private String username;
    private String phone;
    private NameDTO name;
    private AddressDTO address;
}

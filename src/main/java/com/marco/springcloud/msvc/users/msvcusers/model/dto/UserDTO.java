package com.marco.springcloud.msvc.users.msvcusers.model.dto;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class UserDTO
{
    private Long id;
    private String identification;
    private String name;
    private String lastName;
    private String email;
    private String username;
}

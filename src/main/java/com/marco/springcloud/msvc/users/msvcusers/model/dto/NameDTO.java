package com.marco.springcloud.msvc.users.msvcusers.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NameDTO {
  private String firstname;
  private String lastname;
}

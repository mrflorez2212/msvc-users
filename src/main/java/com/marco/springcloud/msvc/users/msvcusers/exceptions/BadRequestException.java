package com.marco.springcloud.msvc.users.msvcusers.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BadRequestException extends RuntimeException
{
  private String message;
}

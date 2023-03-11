package com.marco.springcloud.msvc.users.msvcusers.exceptions;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiError
{
  private HttpStatus status;
  private String message;
  private List<String> errors;
}

package com.marco.springcloud.msvc.users.msvcusers.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse
{
  private int statusCode;
  private String message;
  private String detail;
  private Date date;
}

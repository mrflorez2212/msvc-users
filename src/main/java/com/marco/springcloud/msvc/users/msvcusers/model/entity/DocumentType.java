package com.marco.springcloud.msvc.users.msvcusers.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;


@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DocumentType
{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotEmpty( message = "The type couldn't be null")
  private String type;

  private String description;
}

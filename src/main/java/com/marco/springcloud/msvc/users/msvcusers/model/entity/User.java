package com.marco.springcloud.msvc.users.msvcusers.model.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User
{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(cascade = { CascadeType.MERGE})
  @JoinColumn(name = "documentType")
  @NotNull
  @Valid
  private DocumentType documentType;

  private String identification;

  @NotEmpty(message = "The name couldn't be null")
  @Size( min = 2)
  private String name;

  @NotEmpty(message = "The lastName couldn't be null")
  private String lastName;

  @Column(unique = true)
  @NotEmpty
  @Email
  private String email;

  private String username;

  private String password;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(	name = "user_roles",
      joinColumns = @JoinColumn(name = "user_id"),
      inverseJoinColumns = @JoinColumn(name = "role_id"))
  private Set<Role> roles = new HashSet<>();

  public User(String username, String email, String password) {
    this.username = username;
    this.email = email;
    this.password = password;
  }



}


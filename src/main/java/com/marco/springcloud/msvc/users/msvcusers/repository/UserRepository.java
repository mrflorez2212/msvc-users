package com.marco.springcloud.msvc.users.msvcusers.repository;

import com.marco.springcloud.msvc.users.msvcusers.model.entity.DocumentType;
import com.marco.springcloud.msvc.users.msvcusers.model.entity.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>
{
  List<User> findByName( String name);

  List<User> findByDocumentType( DocumentType documentType );

  List<User> findByNameAndLastName(String name, String lastName);

  Long countByDocumentType(DocumentType documentType);

  User findByEmail(String email);

  Boolean existsByEmail(String email);

  Boolean existsByUsername(String username);




}

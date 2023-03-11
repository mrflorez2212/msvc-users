package com.marco.springcloud.msvc.users.msvcusers.repository;

import com.marco.springcloud.msvc.users.msvcusers.model.entity.ERole;
import com.marco.springcloud.msvc.users.msvcusers.model.entity.Role;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
  Optional<Role> findByName(ERole name);
}

package com.marco.springcloud.msvc.users.msvcusers.service;

import com.marco.springcloud.msvc.users.msvcusers.model.entity.User;
import java.util.List;
import org.springframework.cache.annotation.Cacheable;

public interface IUserService {

  List<User> findAll();

  User findById(final Long id,final String email, final boolean fromApi);

  List<User> findByName(String name);

  User save(User user);

  User updateUser(final User user, final Long id);

  void delete(Long id);

  User findByEmail(final String email);

  User deleteCache(final Long id, final String email);
}

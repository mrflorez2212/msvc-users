package com.marco.springcloud.msvc.users.msvcusers.service.impl;


import com.marco.springcloud.msvc.users.msvcusers.exceptions.BadRequestException;
import com.marco.springcloud.msvc.users.msvcusers.exceptions.NotFoundException;
import com.marco.springcloud.msvc.users.msvcusers.model.dto.UserApi;
import com.marco.springcloud.msvc.users.msvcusers.model.entity.DocumentType;
import com.marco.springcloud.msvc.users.msvcusers.model.entity.User;
import com.marco.springcloud.msvc.users.msvcusers.repository.DocumentTypeRepository;
import com.marco.springcloud.msvc.users.msvcusers.repository.UserRepository;
import com.marco.springcloud.msvc.users.msvcusers.service.IUserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@AllArgsConstructor
public class UserService
    implements IUserService {

  private UserRepository userRepository;
  private DocumentTypeRepository documentTypeRepository;
  private UserAPIService userAPIService;


  @Override
  @Transactional(readOnly = true)
  public List<User> findAll() {
    return userRepository.findAll();
  }


  @Override
  @Transactional(readOnly = true)
  @CircuitBreaker(name = "findUserById", fallbackMethod = "getUserDefault")
  @CachePut(value = "findByEmail", key = "#email")
  public User findById(final Long id, final String email, final boolean fromApi) {
    if (!fromApi) {
      final Optional<User> user = userRepository.findById(id);
      if (!user.isPresent()) {
        throw new NotFoundException(String.format("the userId %s doesn't exists", id));
      }
      return user.get();
    }

    final UserApi userApi = userAPIService.getUserApi(id);
    return User.builder().id(id).lastName(userApi.getName().getLastname())
        .name(userApi.getName().getFirstname()).email(userApi.getEmail()).build();
  }

  @Override
  @CacheEvict(value = "findByEmail", key = "#email")
  public User deleteCache(final Long id, final String email) {
      final Optional<User> user = userRepository.findById(id);
      if (!user.isPresent()) {
        throw new NotFoundException(String.format("the userId %s doesn't exists", id));
      }
      return user.get();
  }


  @Override
  @Transactional(readOnly = true)
  public List<User> findByName(final String name) {
    if (Objects.nonNull(name)) {
      return userRepository.findByName(name);
    }
    return findAll();
  }


  @Override
  @Transactional(readOnly = true)
  @Cacheable(value = "findByEmail", key = "#email")
  public User findByEmail(final String email) {
    if (Objects.nonNull(email)) {
      final User userBD = userRepository.findByEmail(email);
      userBD.setName(userBD.getName() + "test");
      return userBD;
    }
    throw new NotFoundException(String.format("the %s doesn't exists", email));
  }


  @Override
  @Transactional
  public User save(final User user) {
    if (Objects.isNull(user.getDocumentType().getId())) {
      final DocumentType documentType = documentTypeRepository.save(user.getDocumentType());
      user.setDocumentType(documentType);
    }
    return userRepository.save(user);
  }


  @Override
  @Transactional
  public User updateUser(final User user,
      final Long id) {
    final Optional<User> userFound = userRepository.findById(id);
    if (userFound.isPresent()) {
      throw new BadRequestException(String.format("The userId %s doesn't exist", id));
    }
    user.setId(id);
    return userRepository.save(user);
  }


  @Override
  public void delete(final Long id) {
    final User user = findById(id, null, false);
    userRepository.delete(user);
  }

  public User getUserDefault(Exception e) {
    return User.builder().email("test@test.com").id(-1l).lastName("Marco").lastName("ruiz").build();
  }
}


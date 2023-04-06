package com.marco.springcloud.msvc.users.msvcusers.controller;

import com.marco.springcloud.msvc.users.msvcusers.config.MeasureTime;
import com.marco.springcloud.msvc.users.msvcusers.model.entity.User;
import com.marco.springcloud.msvc.users.msvcusers.service.IUserService;
import java.security.Principal;
import java.util.List;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping( value = "/users" )
@AllArgsConstructor
@Slf4j
public class UserController
{
  private IUserService userService;


  @GetMapping
  public ResponseEntity<List<User>> findAll(final Principal principal)
  {
    log.info("principal: " + principal.getName());
    final List<User> users = userService.findAll();
    return ResponseEntity.ok( users );
  }


  @GetMapping( "/{id}" )
  public ResponseEntity<User> findById( @PathVariable final Long id, @RequestParam(required = false) final boolean fromApi, @RequestParam(required = false) final String email )
  {
    return ResponseEntity.ok( userService.findById( id, email, fromApi ) );
  }

  @GetMapping( "/remove/cache/{id}" )
  public ResponseEntity<User> findById( @PathVariable final Long id, @RequestParam(required = false) final String email )
  {
    return ResponseEntity.ok( userService.deleteCache( id, email ) );
  }


  @GetMapping( "/filterByName" )
  public ResponseEntity<List<User>> findByName( @RequestParam( required = false ) final String name )
  {
    final List<User> users = userService.findByName( name );
    return new ResponseEntity( users, HttpStatus.OK );
  }

  @GetMapping( "/filterByEmail" )
  public ResponseEntity<User> filterByEmail( @RequestParam( required = true ) final String email )
  {
    final User user = userService.findByEmail(email);
    return new ResponseEntity( user, HttpStatus.OK );
  }


  @PostMapping
  @MeasureTime
  public ResponseEntity<?> saveUser( @Valid @RequestBody User user )
  {
    final User newUser = userService.save( user );
    return ResponseEntity.status( HttpStatus.CREATED ).body( newUser );
  }


  @PutMapping( "/{id}" )
  public ResponseEntity<?> updateUser( @RequestBody @Valid final User user,
      @PathVariable( required = true ) final Long id )
  {
    final User newUser = userService.updateUser( user, id );
    return ResponseEntity.status( HttpStatus.CREATED ).body( newUser );
  }


  @DeleteMapping( "/{id}" )
  public ResponseEntity<?> deleteUser( @PathVariable final Long id )
  {
    userService.delete( id );
    return ResponseEntity.noContent().build();
  }
}

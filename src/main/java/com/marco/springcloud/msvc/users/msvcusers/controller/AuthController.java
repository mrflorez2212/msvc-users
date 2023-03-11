package com.marco.springcloud.msvc.users.msvcusers.controller;

import com.marco.springcloud.msvc.users.msvcusers.jwt.TokenService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Slf4j
public class AuthController {

  private final TokenService tokenService;

  @PostMapping("/token")
  public String token(Authentication authentication) {
    log.info("Token requested for user: '{}'", authentication.getName());
    String token = tokenService.generateToken(authentication);
    return token;
  }
}

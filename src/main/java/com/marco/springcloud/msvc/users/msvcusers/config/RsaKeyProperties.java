package com.marco.springcloud.msvc.users.msvcusers.config;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConfigurationProperties(prefix = "rsa")
@ConstructorBinding
@Data
@RequiredArgsConstructor
public class RsaKeyProperties {
  RSAPublicKey publicKey;
  RSAPrivateKey privateKey;

}

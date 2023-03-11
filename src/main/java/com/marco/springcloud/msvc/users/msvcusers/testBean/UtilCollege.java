package com.marco.springcloud.msvc.users.msvcusers.testBean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class UtilCollege {

  @Bean
  public Principal principalBean() {
    return Principal.builder().principalName("principal marco").build();
  }

  @Bean
  public Principal principalTest() {
    return Principal.builder().principalName("principal test").build();
  }

  @Bean
  public College college(Principal principalBean, String messi) {
    College college = College.builder().name(messi).principal(principalBean).build();
    college.test();
    return college;
  }

  @Bean
  public College collegeTest(Principal principalTest, String cristiano) {
    College college = College.builder().name(cristiano).principal(principalTest).build();
    college.test();
    return college;
  }

}

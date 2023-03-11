package com.marco.springcloud.msvc.users.msvcusers.testBean;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class NamesBean {
  @Bean
  public String messi(){
    return "messi";
  }

  @Bean
  private String cristiano(){
    return "cristiano";
  }
}

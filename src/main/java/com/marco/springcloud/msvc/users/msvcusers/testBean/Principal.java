package com.marco.springcloud.msvc.users.msvcusers.testBean;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class Principal {

  private String principalName;

  public void principalInfo(){
    System.out.println("principal info");
  }

}

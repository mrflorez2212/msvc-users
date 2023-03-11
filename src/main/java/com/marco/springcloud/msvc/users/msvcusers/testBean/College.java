package com.marco.springcloud.msvc.users.msvcusers.testBean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class College {

    private Principal principal;
    private String name;

    public void test(){
       principal.principalInfo();
       System.out.println(getName());
    }
}

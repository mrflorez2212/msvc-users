package com.marco.springcloud.msvc.users.msvcusers.service.impl;

import com.marco.springcloud.msvc.users.msvcusers.model.dto.UserApi;
import com.marco.springcloud.msvc.users.msvcusers.service.IUserAPIService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserAPIService implements IUserAPIService {

  private String url;
  private RestTemplate restTemplate;

  public UserAPIService(@Value("${user.api.fake.url}") String url, RestTemplate restTemplate) {
    this.url = url;
    this.restTemplate = restTemplate;
  }

  @Override
  public UserApi getUserApi(Long id) {
    final UserApi userApi = restTemplate.getForObject(url + "/" + id, UserApi.class);
    return  userApi;
  }
}

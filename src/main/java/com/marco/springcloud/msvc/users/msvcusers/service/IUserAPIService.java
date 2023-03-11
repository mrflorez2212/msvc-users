package com.marco.springcloud.msvc.users.msvcusers.service;

import com.marco.springcloud.msvc.users.msvcusers.model.dto.UserApi;

public interface IUserAPIService {

    public UserApi getUserApi(final Long id);
}

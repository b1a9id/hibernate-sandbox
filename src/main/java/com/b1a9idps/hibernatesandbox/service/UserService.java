package com.b1a9idps.hibernatesandbox.service;

import java.util.List;

import com.b1a9idps.hibernatesandbox.dto.UserCreateDto;
import com.b1a9idps.hibernatesandbox.dto.UserDto;

public interface UserService {

    UserDto create(UserCreateDto createDto);

    List<UserDto> bulkCreate(List<UserCreateDto> userCreateDtoList);

    List<UserDto> list();
}

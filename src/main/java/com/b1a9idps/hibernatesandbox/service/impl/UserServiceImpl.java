package com.b1a9idps.hibernatesandbox.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.b1a9idps.hibernatesandbox.dto.UserCreateDto;
import com.b1a9idps.hibernatesandbox.dto.UserDto;
import com.b1a9idps.hibernatesandbox.entity.User;
import com.b1a9idps.hibernatesandbox.entity.UserBuilder;
import com.b1a9idps.hibernatesandbox.repository.UserRepository;
import com.b1a9idps.hibernatesandbox.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto create(UserCreateDto createDto) {
        User user = UserBuilder.builder()
                .withName(createDto.name())
                .withGender(createDto.gender())
                .withAge(createDto.age())
                .build();
        return UserDto.from(userRepository.save(user));
    }

    @Override
    public List<UserDto> list() {
        return userRepository.findAll().stream()
                .map(UserDto::from)
                .collect(Collectors.toList());
    }
}

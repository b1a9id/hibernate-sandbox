package com.b1a9idps.hibernatesandbox.service.impl;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.b1a9idps.hibernatesandbox.dto.UserCreateDto;
import com.b1a9idps.hibernatesandbox.dto.UserDto;
import com.b1a9idps.hibernatesandbox.entity.User;
import com.b1a9idps.hibernatesandbox.entity.UserBuilder;
import com.b1a9idps.hibernatesandbox.repository.UserRepository;
import com.b1a9idps.hibernatesandbox.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private static final Function<UserCreateDto, User> CREATE_DTO_USER_FUNCTION =
            createDto -> UserBuilder.builder()
                    .withName(createDto.name())
                    .withGender(createDto.gender())
                    .withAge(createDto.age())
                    .build();

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public UserDto create(UserCreateDto createDto) {
        var user = CREATE_DTO_USER_FUNCTION.apply(createDto);
        return UserDto.from(userRepository.save(user));
    }

    @Override
    public List<UserDto> list() {
        return userRepository.findAll().stream()
                .map(UserDto::from)
                .collect(Collectors.toList());
    }
}

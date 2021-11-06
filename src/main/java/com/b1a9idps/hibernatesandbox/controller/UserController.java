package com.b1a9idps.hibernatesandbox.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.b1a9idps.hibernatesandbox.dto.UserCreateDto;
import com.b1a9idps.hibernatesandbox.dto.UserDto;
import com.b1a9idps.hibernatesandbox.dto.request.UserCreateRequest;
import com.b1a9idps.hibernatesandbox.dto.response.UserResponse;
import com.b1a9idps.hibernatesandbox.service.UserService;

@RestController
@RequestMapping("/users")
public record UserController(UserService userService) {

    @GetMapping
    public List<UserResponse> list() {
        return userService.list().stream()
                .map(UserResponse::from)
                .collect(Collectors.toList());
    }

    @PostMapping
    public UserResponse create(@RequestBody @Validated UserCreateRequest request) {
        UserDto userDto = userService.create(new UserCreateDto(request.name(), request.gender(), request.age()));
        return UserResponse.from(userDto);
    }
}

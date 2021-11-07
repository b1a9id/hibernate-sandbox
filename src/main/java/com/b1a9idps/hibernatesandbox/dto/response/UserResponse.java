package com.b1a9idps.hibernatesandbox.dto.response;

import java.time.LocalDateTime;

import com.b1a9idps.hibernatesandbox.dto.UserDto;
import com.b1a9idps.hibernatesandbox.enums.Gender;

public record UserResponse(
        Long id,
        String name,
        Gender gender,
        Integer age,
        LocalDateTime createdAt,
        LocalDateTime updatedAt) {

    public static UserResponse from(UserDto user) {
        return new UserResponse(
                user.id(),
                user.name(),
                user.gender(),
                user.age(),
                user.createdAt(),
                user.updatedAt()
        );
    }
}

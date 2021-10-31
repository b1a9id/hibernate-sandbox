package com.b1a9idps.hibernatesandbox.dto;

import java.time.LocalDateTime;

import com.b1a9idps.hibernatesandbox.entity.User;
import com.b1a9idps.hibernatesandbox.enums.Gender;

public record UserDto(
        Long id,
        String name,
        Gender gender,
        Integer age,
        LocalDateTime createdAt,
        LocalDateTime updatedAt) {

    public static UserDto from(User user) {
        return new UserDto(
                user.getId(),
                user.getName(),
                user.getGender(),
                user.getAge(),
                user.getCreatedAt(),
                user.getUpdatedAt()
        );
    }
}

package com.b1a9idps.hibernatesandbox.dto;

import com.b1a9idps.hibernatesandbox.enums.Gender;

public record UserCreateDto(
        String name,
        Gender gender,
        Integer age) {
}

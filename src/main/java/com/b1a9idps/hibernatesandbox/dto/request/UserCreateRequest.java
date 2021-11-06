package com.b1a9idps.hibernatesandbox.dto.request;

import javax.validation.constraints.NotNull;

import com.b1a9idps.hibernatesandbox.enums.Gender;

public record UserCreateRequest(
        @NotNull String name,
        @NotNull Gender gender,
        Integer age) {
}

package com.b1a9idps.hibernatesandbox.dto.request;

import com.b1a9idps.hibernatesandbox.enums.Gender;
import com.sun.istack.NotNull;

public record UserCreateRequest(
        @NotNull String name,
        @NotNull Gender gender,
        Integer age) {
}

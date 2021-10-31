package com.b1a9idps;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.b1a9idps.hibernatesandbox.dto.UserCreateDto;
import com.b1a9idps.hibernatesandbox.enums.Gender;
import com.b1a9idps.hibernatesandbox.service.UserService;

@Component
public record Runner(UserService userService) implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        var name = "test";
        var gender = Gender.MAN;
        var age = 20;

        var userCreateDtoList = IntStream.rangeClosed(0, 50)
                        .mapToObj(i -> new UserCreateDto(name + i, gender, age + i))
                                .collect(Collectors.toList());
        userService.bulkCreate(userCreateDtoList);
    }
}

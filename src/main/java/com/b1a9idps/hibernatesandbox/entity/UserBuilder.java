package com.b1a9idps.hibernatesandbox.entity;

import com.b1a9idps.hibernatesandbox.enums.Gender;

public class UserBuilder {
    private String name;
    private Gender gender;
    private Integer age;

    private UserBuilder() {}

    public static UserBuilder builder() {
        return new UserBuilder();
    }

    public UserBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public UserBuilder withGender(Gender gender) {
        this.gender = gender;
        return this;
    }

    public UserBuilder withAge(Integer age) {
        this.age = age;
        return this;
    }

    public User build() {
        return new User(name, gender, age);
    }
}

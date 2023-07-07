package org.example.provider;

import org.apache.commons.lang3.RandomStringUtils;
import org.example.dto.CreateUserRequest;

public class UserProvider {

    public static final String MAIL_PREFIX = "@mail.ru";

    public static CreateUserRequest getRandomUserWithValidCredentials() {
        return CreateUserRequest.builder()
                .email(RandomStringUtils.randomAlphabetic(8) + MAIL_PREFIX)
                .password(RandomStringUtils.randomAlphabetic(8))
                .name(RandomStringUtils.randomAlphabetic(8))
                .build();
    }

    public static CreateUserRequest getRandomUserWithInvalidCredentials() {
        return CreateUserRequest.builder()
                .email(RandomStringUtils.randomAlphabetic(8) + MAIL_PREFIX)
                .password(RandomStringUtils.randomAlphabetic(5))
                .name(RandomStringUtils.randomAlphabetic(8))
                .build();
    }

}

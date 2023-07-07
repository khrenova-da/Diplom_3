package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LoginUserRequest {
    private String email;
    private String password;

    public static LoginUserRequest from(CreateUserRequest createUserRequest) {
        return new LoginUserRequest(createUserRequest.getEmail(), createUserRequest.getPassword());
    }
}

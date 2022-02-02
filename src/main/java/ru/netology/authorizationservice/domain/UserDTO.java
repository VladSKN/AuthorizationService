package ru.netology.authorizationservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDTO {

    private final String name;
    private final String password;
}

package ru.netology.authorizationservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@Validated
public class User {

    @NotNull
    @Size(min = 2, max = 20)
    private final String user;
    @NotNull
    @Size(min = 5, max = 25)
    private final String password;
}

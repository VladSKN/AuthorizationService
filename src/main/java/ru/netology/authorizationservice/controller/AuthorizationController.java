package ru.netology.authorizationservice.controller;

import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.authorizationservice.authorities.Authorities;
import ru.netology.authorizationservice.domain.UserDTO;
import ru.netology.authorizationservice.service.AuthorizationService;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@Validated
public class AuthorizationController {

    private AuthorizationService service;

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@Valid UserDTO user) {
        return service.getAuthorities(user);
    }
}
package ru.netology.authorizationservice.controller;

import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.authorizationservice.authorities.Authorities;
import ru.netology.authorizationservice.service.AuthorizationService;

import javax.validation.constraints.Size;
import java.util.List;

@RestController
@AllArgsConstructor
@Validated
public class AuthorizationController {

    private AuthorizationService service;

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@RequestParam("user") @Size(min = 2, max = 20) String user,
                                            @RequestParam("password") @Size(min = 5, max = 25) String password) {
        return service.getAuthorities(user, password);
    }
}
package ru.netology.authorizationservice;

import org.junit.jupiter.api.Test;
import ru.netology.authorizationservice.authorities.Authorities;
import ru.netology.authorizationservice.repository.UserRepository;
import ru.netology.authorizationservice.service.AuthorizationService;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


class AuthorizationServiceApplicationTests {
    private final UserRepository userRepository = mock(UserRepository.class);
    private final AuthorizationService service = new AuthorizationService(userRepository);


    @Test
    void getUserAuthoritiesTest() {
        String name = "admin";
        String password = "password";
        when(userRepository.getUserAuthorities(name, password))
                .thenReturn(List.of(Authorities.DELETE, Authorities.READ, Authorities.WRITE));
    }
}

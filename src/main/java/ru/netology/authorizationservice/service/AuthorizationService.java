package ru.netology.authorizationservice.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import ru.netology.authorizationservice.authorities.Authorities;
import ru.netology.authorizationservice.domain.UserDTO;
import ru.netology.authorizationservice.exception.InvalidCredentials;
import ru.netology.authorizationservice.exception.UnauthorizedUser;
import ru.netology.authorizationservice.repository.UserRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class AuthorizationService {

    private UserRepository userRepository;

    public List<Authorities> getAuthorities(UserDTO user) {
        if (!StringUtils.hasText(user.getUser()) || !StringUtils.hasText(user.getPassword())) {
            throw new InvalidCredentials("User name or password is empty");
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user);
        if (CollectionUtils.isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user);
        }
        return userAuthorities;
    }
}
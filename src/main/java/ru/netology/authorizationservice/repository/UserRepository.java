package ru.netology.authorizationservice.repository;

import org.springframework.stereotype.Repository;
import ru.netology.authorizationservice.authorities.Authorities;
import ru.netology.authorizationservice.domain.UserDTO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class UserRepository {

    private final UserDTO admin = new UserDTO("admin", "password");
    private final UserDTO reader = new UserDTO("reader", "123456");
    private final UserDTO writer = new UserDTO("writer", "987654");
    private final List<Authorities> adminAuthorities = Arrays.asList(Authorities.DELETE, Authorities.READ, Authorities.WRITE);
    private final List<Authorities> readerAuthorities = Arrays.asList(Authorities.DELETE, Authorities.READ);
    private final List<Authorities> writerAuthorities = List.of(Authorities.WRITE);


    public List<Authorities> getUserAuthorities(UserDTO user) {
        if (admin.getUser().equals(user.getUser()) && (admin.getPassword().equals(user.getPassword()))) {
            return adminAuthorities;
        } else if (reader.getUser().equals(user.getUser()) && (reader.getPassword().equals(user.getPassword()))) {
            return readerAuthorities;
        } else if (writer.getUser().equals(user.getUser()) && (writer.getPassword().equals(user.getPassword()))) {
            return writerAuthorities;
        }
        return new ArrayList<>();
    }
}
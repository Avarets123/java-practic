package ru.web.firstwebapp.repositories;

import ru.web.firstwebapp.models.User;

import java.util.List;

public interface UserRepository {
    List<User> findAll(String orderBy, String dir);

    void save(User newUser);

    User findById(Long id );
}

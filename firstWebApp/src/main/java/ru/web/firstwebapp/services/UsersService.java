package ru.web.firstwebapp.services;

import ru.web.firstwebapp.models.User;

import java.util.List;

public interface UsersService {
    List<User> getAllUsers(String orderBy, String dir);

    void addUser(User newUser);

    User getUser(Long id);
}

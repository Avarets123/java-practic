package ru.web.firstwebapp.services;

import ru.web.firstwebapp.dto.UserForm;
import ru.web.firstwebapp.models.User;

import java.util.List;

public interface UsersService {
    List<User> getAllUsers();

    void addUser(UserForm user);

    User getUser(Long id);

    void updateUser(Long userId, UserForm user);

    void deleteUser(Long userId);
}

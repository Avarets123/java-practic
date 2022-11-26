package ru.web.firstwebapp.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.web.firstwebapp.models.User;
import ru.web.firstwebapp.repositories.UserRepository;
import ru.web.firstwebapp.services.UsersService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService {

    private final UserRepository userRepository;

    @Override
    public List<User> getAllUsers(String orderBy, String dir) {
        return userRepository.findAll(orderBy, dir);
    }

    @Override
    public void addUser(User newUser) {
        User user = User.builder()
                .email(newUser.getEmail())
                .password(newUser.getPassword())
                .description(newUser.getDescription())
                .build();
        userRepository.save(user);
    }

    @Override
    public User getUser(Long id) {
        return userRepository.findById(id);
    }
}

package ru.web.firstwebapp.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.web.firstwebapp.dto.UserForm;
import ru.web.firstwebapp.models.User;
import ru.web.firstwebapp.repositories.UserRepository;
import ru.web.firstwebapp.services.UsersService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService {

    private final UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAllByStateNot(User.State.DELETED);
    }


    @Override
    public void addUser(UserForm newUser) {
        User user = User.builder()
                .email(newUser.getEmail())
                .firstName(newUser.getFirstName())
                .lastName(newUser.getLastName())
                .state(User.State.NOT_CONFIRMED)
                .build();
        userRepository.save(user);
    }

    @Override
    public User getUser(Long id) {
        return userRepository.findById(id).orElseThrow();
    }

    @Override
    public void updateUser(Long userId, UserForm user) {
        User newUser = userRepository.findById(userId).orElseThrow();

        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setAge(user.getAge());

        userRepository.save(newUser);
    }

    @Override
    public void deleteUser(Long userId) {

        User userForDelete = userRepository.findById(userId).orElseThrow();
        userForDelete.setState(User.State.DELETED);

        userRepository.save(userForDelete);



    }
}

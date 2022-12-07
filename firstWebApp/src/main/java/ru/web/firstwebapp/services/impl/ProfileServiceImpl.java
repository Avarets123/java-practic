package ru.web.firstwebapp.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.web.firstwebapp.models.User;
import ru.web.firstwebapp.repositories.UserRepository;
import ru.web.firstwebapp.security.details.CustomUserDetails;
import ru.web.firstwebapp.services.ProfileService;

@RequiredArgsConstructor
@Service
public class ProfileServiceImpl implements ProfileService {

    private final UserRepository userRepository;


    @Override
    public User getCurrent(CustomUserDetails customUserDetails) {
        return userRepository.findById(customUserDetails.getUser().getId()).orElseThrow();
    }
}

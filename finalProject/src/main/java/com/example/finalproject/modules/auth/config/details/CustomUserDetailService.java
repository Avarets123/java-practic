package com.example.finalproject.modules.auth.config.details;

import com.example.finalproject.modules.users.entity.UserEntity;
import com.example.finalproject.modules.users.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByEmailAndStateNot(email, UserEntity.State.DELETED).orElseThrow();
        return new CustomUserDetails(user);
    }
}

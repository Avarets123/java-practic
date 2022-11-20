package org.spring.services.impl;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.spring.models.User;
import org.spring.repositories.UserRepository;
import org.spring.services.UsersService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService {

  private final UserRepository userRepository;

  @Override
  public List<User> getAllUsers() {
    return userRepository.findAll();
  }
}

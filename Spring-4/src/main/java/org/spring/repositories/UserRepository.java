package org.spring.repositories;

import org.spring.models.User;

public interface UserRepository {
  void save(User user);
}

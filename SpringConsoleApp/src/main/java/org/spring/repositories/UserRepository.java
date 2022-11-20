package org.spring.repositories;

import java.util.List;
import org.spring.models.User;

public interface UserRepository {
  List<User> findAll();
}

package org.spring.repositories.impl;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.spring.models.User;
import org.spring.repositories.UserRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

  private final JdbcTemplate jdbcTemplate;

  private static final String SQL_SELECT_ALL = "select * from account";


  private final static RowMapper<User> rowUserMapper = (user, num) ->
      User.builder()
          .id(user.getLong("id"))
          .email(user.getString("email"))
          .password(user.getString("password"))
          .build();

  @Override
  public List<User> findAll() {
    return this.jdbcTemplate.query(SQL_SELECT_ALL, rowUserMapper);
  }
}

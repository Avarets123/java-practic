package org.spring.repositories.impls;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.spring.models.User;
import org.spring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UsersRepositoryJdbcImpl implements UserRepository {

  private final DataSource dataSource;

  private static final String SQL_INSERT = "insert into account(email, password) " +
      "values(?, ?)";


  @Autowired
  public UsersRepositoryJdbcImpl(DataSource dataSource) {
    this.dataSource = dataSource;
  }


  @Override
  public void save(User user) {
    try (Connection connection = dataSource.getConnection();
         PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT)
    ) {
      preparedStatement.setString(1, user.getEmail());
      preparedStatement.setString(2, user.getPassword());
      preparedStatement.executeUpdate();
    } catch (SQLException e) {
      throw new IllegalStateException(e);
    }
  }
}

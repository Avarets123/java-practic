package org.spring1.repositories.impls;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.spring1.models.User;
import org.spring1.repositories.UserRepository;

public class UsersRepositoryJdbcImpl implements UserRepository {

  private final DataSource dataSource;

  private static final String SQL_INSERT = "insert into account(email, password) " +
      "values(?, ?)";


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

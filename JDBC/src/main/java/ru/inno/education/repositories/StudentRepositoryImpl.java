package ru.inno.education.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import javax.sql.DataSource;
import ru.inno.education.models.Student;

public class StudentRepositoryImpl implements StudentRepository {

  private static final String SQL_SELECT_ALL = "select * from student order by id";
  private static final String SQL_INSERT =
      "insert into student (email, password, first_name, lastname, age, is_worker, average)" +
          " values(?, ?, ?, ?, ?, ?, ?)";

  private final DataSource dataSource;


  public StudentRepositoryImpl(DataSource dataSource) {
    this.dataSource = dataSource;
  }

  @Override
  public List<Student> findAll() {
    List<Student> students = new ArrayList<>();

    try (Connection connection = dataSource.getConnection()) {
      Statement statement = connection.createStatement();
      try (ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL)) {
        while (resultSet.next()) {

          Student student = userRowMapper.apply(resultSet);
          students.add(student);
        }
      }
    } catch (SQLException e) {
      throw new IllegalArgumentException(e);
    }

    return students;
  }

  private static final Function<ResultSet, Student> userRowMapper = resultSet -> {
    try {
      return Student.builder()
          .id(resultSet.getLong("id"))
          .email(resultSet.getString("email"))
          .password(resultSet.getString("password"))
          .first_name(resultSet.getString("first_name"))
          .last_name(resultSet.getString("last_name"))
          .age(resultSet.getInt("age"))
          .isWorker(resultSet.getBoolean("is_worker"))
          .build();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  };

  @Override
  public void save(Student student) {

    try (Connection connection = dataSource.getConnection()) {
      PreparedStatement preparedStatement =
          connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
      preparedStatement.setString(1, student.getEmail());
      preparedStatement.setString(2, student.getPassword());
      preparedStatement.setString(3, student.getFirst_name());
      preparedStatement.setString(4, student.getLast_name());
      preparedStatement.setInt(5, student.getAge());
      preparedStatement.setBoolean(6, student.getIsWorker());
      preparedStatement.setDouble(7, student.getAverage());

      int affectedRows = preparedStatement.executeUpdate();

      if (affectedRows != 1) {
        throw new SQLException("Can't insert student");
      }

      try (ResultSet generatedId = preparedStatement.getGeneratedKeys()) {

        if (generatedId.next()) {
          student.setId(generatedId.getLong("id"));
        } else {
          throw new SQLException("Can't obtain generated id");
        }

      }

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }

  }
}

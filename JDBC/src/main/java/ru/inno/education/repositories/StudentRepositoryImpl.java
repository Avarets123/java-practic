package ru.inno.education.repositories;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import ru.inno.education.models.Student;

public class StudentRepositoryImpl implements StudentRepository {

  private static final String SQL_SELECT_ALL = "select * from student order by id";
  private final Connection connection;


  public StudentRepositoryImpl(Connection connection) {
    this.connection = connection;
  }

  @Override
  public List<Student> findAll() {
    List<Student> students = new ArrayList<>();

    try (Statement statement = connection.createStatement()) {
      try (ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL)) {
        while (resultSet.next()) {
          Student student = Student.builder()
              .id(resultSet.getLong("id"))
              .email(resultSet.getString("email"))
              .password(resultSet.getString("email"))
              .first_name(resultSet.getString("first_name"))
              .last_name(resultSet.getString("last_name"))
              .age(resultSet.getInt("age"))
              .isWorker(resultSet.getBoolean("is_worker"))
              .build();

          students.add(student);
        }
      }
    } catch (SQLException e) {
      throw new IllegalArgumentException(e);
    }

    return students;
  }

  @Override
  public void save(Student student) {

  }
}

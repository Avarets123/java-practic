package ru.inno.education.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import java.util.Properties;
import ru.inno.education.models.Student;
import ru.inno.education.repositories.StudentRepository;
import ru.inno.education.repositories.StudentRepositoryImpl;

public class Main {
  public static void main(String[] args) {

    Properties properties = new Properties();

    try {
      properties.load(
          new BufferedReader(
              new InputStreamReader(
                  Objects.requireNonNull(Main.class.getResourceAsStream("/db.properties")))));

      Connection connection = DriverManager.getConnection(
          properties.getProperty("db.url"),
          properties.getProperty("db.username"),
          properties.getProperty("db.password")
      );

      StudentRepository studentRepository = new StudentRepositoryImpl(connection);
      List<Student> students = studentRepository.findAll();
      System.out.println(students);
    } catch (SQLException | IOException e) {
      throw new RuntimeException(e);
    }

  }
}
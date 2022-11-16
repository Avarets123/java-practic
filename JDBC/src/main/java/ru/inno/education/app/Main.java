package ru.inno.education.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.Properties;
import ru.inno.education.models.Student;
import ru.inno.education.repositories.StudentRepository;
import ru.inno.education.repositories.StudentRepositoryImpl;
import com.zaxxer.hikari.*;

public class Main {
  public static void main(String[] args) {

    Properties properties = new Properties();

    try {
      properties.load(
          new BufferedReader(
              new InputStreamReader(
                  Objects.requireNonNull(Main.class.getResourceAsStream("/db.properties")))));

    } catch (IOException e) {
      throw new IllegalArgumentException(e);
    }

    HikariDataSource dataSource = new HikariDataSource();
    dataSource.setUsername(properties.getProperty("db.username"));
    dataSource.setJdbcUrl(properties.getProperty("db.url"));
    dataSource.setPassword(properties.getProperty("db.password"));
    dataSource.setMaximumPoolSize(
        Integer.parseInt(properties.getProperty("db.hikari.maxPoolSize")));


    StudentRepository studentRepository = new StudentRepositoryImpl(dataSource);

    Student student = Student
        .builder()
        .password("qwerty111")
        .email("ava@gma.com")
        .age(22)
        .isWorker(true)
        .first_name("gas")
        .average(4.5)
        .last_name("osm")
        .build();

    studentRepository.save(student);
    System.out.println(student);

  }
}
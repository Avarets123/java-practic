package ru.inno.injection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;
import java.util.Properties;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Properties dbProperties = new Properties();

    try {
      dbProperties.load(
          new BufferedReader(new InputStreamReader(
              Objects.requireNonNull(
                  ru.inno.education.app.Main.class.getResourceAsStream("/db.properties")))));
      Connection connection = DriverManager.getConnection(
          dbProperties.getProperty("db.url"),
          dbProperties.getProperty("db.username"),
          dbProperties.getProperty("db.password")
      );

      Scanner scanner = new Scanner(System.in);
      String lessonName = scanner.nextLine();
      String id = scanner.nextLine();

      String sql = "insert into student(email, id, password, age) values ('" + lessonName + "', " + id +
          ", 'qwerty000'," + 25 + ")";
      System.out.println(sql);

      Statement statement = connection.createStatement();

      statement.executeUpdate(sql);

    } catch (IOException | SQLException e) {
      throw new RuntimeException(e);
    }
  }
}

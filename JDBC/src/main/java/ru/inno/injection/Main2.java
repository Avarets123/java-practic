package ru.inno.injection;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Objects;
import java.util.Properties;
import java.util.Scanner;
import ru.inno.education.app.Main;

public class Main2 {
  public static void main(String[] args) throws Exception {

    Properties dbProperties = new Properties();

    dbProperties.load(new BufferedReader(
        new InputStreamReader(
            Objects.requireNonNull(Main.class.getResourceAsStream("/db.properties")))));

    Connection connection = DriverManager.getConnection(
        dbProperties.getProperty("db.url"),
        dbProperties.getProperty("db.username"),
        dbProperties.getProperty("db.password"));

    Scanner scanner = new Scanner(System.in);

    String lessonName = scanner.nextLine();

    String sql = "insert into lesson(name) values (?)";
    PreparedStatement statement = connection.prepareStatement(sql);
    statement.setString(1, lessonName);

    statement.executeUpdate();

  }
}

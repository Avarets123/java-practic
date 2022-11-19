package org.spring1;

import com.zaxxer.hikari.HikariDataSource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.Properties;
import org.spring1.repositories.UserRepository;
import org.spring1.repositories.impls.UsersRepositoryFilesImpl;
import org.spring1.repositories.impls.UsersRepositoryJdbcImpl;
import org.spring1.services.UsersServiceImpl;
import org.spring1.validators.EmailValidator;
import org.spring1.validators.PasswordValidator;
import org.spring1.validators.impl.EmailRegexValidator;
import org.spring1.validators.impl.EmailSimpleValidator;
import org.spring1.validators.impl.PasswordLengthValidator;

public class Main {
  public static void main(String[] args) {

    Properties dbProperties = new Properties();

    try {
      dbProperties.load(new BufferedReader(
          new InputStreamReader(
              Objects.requireNonNull(Main.class.getResourceAsStream("/db.properties")))
      ));

    } catch (IOException e) {
      throw new IllegalArgumentException(e);
    }

    HikariDataSource dataSource = new HikariDataSource();
    dataSource.setPassword(dbProperties.getProperty("db.password"));
    dataSource.setJdbcUrl(dbProperties.getProperty("db.url"));
    dataSource.setUsername(dbProperties.getProperty("db.username"));
    dataSource.setMaximumPoolSize(
        Integer.parseInt(dbProperties.getProperty("db.hikari.maxPoolSize")));

    String regex =
        "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";


    EmailValidator emailValidator = new EmailSimpleValidator("@.");
    EmailValidator emailValidator1 = new EmailRegexValidator(regex);

    UserRepository usersRepositoryFiles = new UsersRepositoryFilesImpl("users.txt");
    UserRepository usersRepositoryJdbc = new UsersRepositoryJdbcImpl(dataSource);

    PasswordLengthValidator passwordValidator = new PasswordLengthValidator();
    passwordValidator.setMinLength(5);

    UsersServiceImpl usersService = new UsersServiceImpl(
        usersRepositoryFiles,
        passwordValidator,
        emailValidator
    );

    usersService.signUp("aaa@gmail.com", "234fvewr3243g");

  }


}
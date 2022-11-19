package org.spring1.services;

import org.spring1.models.User;
import org.spring1.repositories.UserRepository;
import org.spring1.validators.EmailValidator;
import org.spring1.validators.PasswordValidator;

public class UsersServiceImpl {

  private final UserRepository usersRepository;
  private final PasswordValidator passwordValidator;
  private final EmailValidator emailValidator;

  public UsersServiceImpl(
      UserRepository usersRepository,
      PasswordValidator passwordValidator,
      EmailValidator emailValidator
  ) {
    this.usersRepository = usersRepository;
    this.emailValidator = emailValidator;
    this.passwordValidator = passwordValidator;
  }

  public void signUp(String email, String password) {
    emailValidator.validate(email);
    passwordValidator.validate(password);

    User user = User.builder()
        .email(email)
        .password(password)
        .build();

    usersRepository.save(user);
  }
}

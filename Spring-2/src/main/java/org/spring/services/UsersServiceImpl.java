package org.spring.services;

import org.spring.models.User;
import org.spring.repositories.UserRepository;
import org.spring.validators.EmailValidator;
import org.spring.validators.PasswordValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class UsersServiceImpl {

  private final UserRepository usersRepository;
  private final PasswordValidator passwordValidator;
  private final EmailValidator emailValidator;

  @Autowired
  public UsersServiceImpl(
      @Qualifier("usersRepositoryJdbcImpl") UserRepository usersRepository,
      PasswordValidator passwordValidator,
      @Qualifier("emailSimpleValidator") EmailValidator emailValidator
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

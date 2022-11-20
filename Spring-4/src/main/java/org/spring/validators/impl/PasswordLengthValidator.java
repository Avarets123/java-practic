package org.spring.validators.impl;

import org.spring.validators.PasswordValidator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PasswordLengthValidator implements PasswordValidator {

  private final int minLength;

  public PasswordLengthValidator(
      @Value("${password.validator.length}") int minLength

      ) {
    this.minLength = minLength;
  }

  @Override
  public void validate(String password) {
    if (password.length() < minLength) {
      throw new IllegalArgumentException("Incorrect password format");
    }
  }

}

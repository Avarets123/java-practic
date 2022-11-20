package org.spring.validators.impl;

import org.spring.validators.PasswordValidator;

public class PasswordLengthValidator implements PasswordValidator {

  private int minLength;

  @Override
  public void validate(String password) {
    if (password.length() < minLength) {
      throw new IllegalArgumentException("Incorrect password format");
    }
  }

  public void setMinLength(int minLength) {
    this.minLength = minLength;
  }
}

package org.spring1.validators.impl;

import java.util.regex.Pattern;
import org.spring1.validators.EmailValidator;

public class EmailRegexValidator implements EmailValidator {
  private final String regex;

  public EmailRegexValidator(String regex) {
    this.regex = regex;
  }

  @Override
  public void validate(String email) {
    if (Pattern.compile(regex).matcher(email).matches()) {
      throw new IllegalArgumentException("Incorrect email");
    }
  }
}

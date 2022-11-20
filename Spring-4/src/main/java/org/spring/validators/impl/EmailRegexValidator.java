package org.spring.validators.impl;

import java.util.regex.Pattern;
import org.spring.validators.EmailValidator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class EmailRegexValidator implements EmailValidator {

  private final String regex;

  public EmailRegexValidator(
      @Value("${email.regex.validator.regex}") String regex
  ) {
    this.regex = regex;
  }


  @Override
  public void validate(String email) {
    if (!Pattern.compile(regex).matcher(email).matches()) {
      throw new IllegalArgumentException("Incorrect email");
    }
  }
}

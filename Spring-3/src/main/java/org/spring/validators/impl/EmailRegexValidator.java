package org.spring.validators.impl;

import java.util.regex.Pattern;
import org.spring.validators.EmailValidator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class EmailRegexValidator implements EmailValidator {

  @Value("${email.regex.validator.regex}")
  private  String regex;


  @Override
  public void validate(String email) {
    if (Pattern.compile(regex).matcher(email).matches()) {
      throw new IllegalArgumentException("Incorrect email");
    }
  }
}

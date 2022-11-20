package org.spring.validators.impl;

import org.spring.validators.EmailValidator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class EmailSimpleValidator implements EmailValidator {

  @Value("${email.simple.validator.characters}")
  private   String characters;


  @Override
  public void validate(String email) {
    for (char character: characters.toCharArray() ) {
      if (email.indexOf(character) == -1) {
        throw new IllegalArgumentException("Incorrect email");
      }
    }
  }
}

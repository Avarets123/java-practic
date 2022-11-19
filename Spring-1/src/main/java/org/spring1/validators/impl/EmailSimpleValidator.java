package org.spring1.validators.impl;

import org.spring1.validators.EmailValidator;

public class EmailSimpleValidator implements EmailValidator {
  private final  String characters;

  public EmailSimpleValidator(String characters) {
    this.characters = characters;
  }

  @Override
  public void validate(String email) {
    for (char character: characters.toCharArray() ) {
      if (email.indexOf(character) == -1) {
        throw new IllegalArgumentException("Incorrect email");
      }
    }
  }
}

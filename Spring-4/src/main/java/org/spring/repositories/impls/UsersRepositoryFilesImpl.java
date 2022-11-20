package org.spring.repositories.impls;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import org.spring.models.User;
import org.spring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

public class UsersRepositoryFilesImpl implements UserRepository {

  private  String filename;


  @Override
  public void save(User user) {
    try (FileWriter fileWriter = new FileWriter(filename, true);
         BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

      String userToSave = user.getEmail() + "|" + user.getPassword();
      bufferedWriter.write(userToSave);
      bufferedWriter.newLine();

    } catch (IOException e) {
      throw new IllegalArgumentException(e);
    }

  }
}

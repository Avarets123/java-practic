package org.spring1.repositories.impls;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import org.spring1.models.User;
import org.spring1.repositories.UserRepository;

public class UsersRepositoryFilesImpl implements UserRepository {

  private final String filename;

  public UsersRepositoryFilesImpl(String filename) {
    this.filename = filename;
  }

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

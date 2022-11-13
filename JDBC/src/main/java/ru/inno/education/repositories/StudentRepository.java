package ru.inno.education.repositories;

import java.util.List;
import ru.inno.education.models.Student;

public interface StudentRepository {
  List<Student> findAll();

  void save(Student student);
}

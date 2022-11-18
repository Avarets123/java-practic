package ru.hibernate.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import java.util.List;
import lombok.RequiredArgsConstructor;
import ru.hibernate.models.Student;

@RequiredArgsConstructor
public class StudentRepository implements CrudRepository<Student> {

  private final EntityManager entityManager;

  @Override
  public void save(Student entity) {
    EntityTransaction transaction = entityManager.getTransaction();
    transaction.begin();
    entityManager.persist(entity);
    transaction.commit();
  }

  @Override
  public List<Student> findAll() {
    return entityManager
        .createQuery("select student from Student student", Student.class)
        .getResultList();
  }

  @Override
  public Student findById(Long id) {
    return entityManager.find(Student.class, id);
  }
}

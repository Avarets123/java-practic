package ru.hibernate.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import java.util.List;
import lombok.RequiredArgsConstructor;
import ru.hibernate.models.Course;

@RequiredArgsConstructor
public class CourseRepository implements CrudRepository<Course> {

  private final EntityManager entityManager;


  @Override
  public void save(Course entity) {
    EntityTransaction transaction = entityManager.getTransaction();
    transaction.begin();
    entityManager.persist(entity);
    transaction.commit();

  }

  @Override
  public List<Course> findAll() {
    return entityManager
        .createQuery("select course from Course course", Course.class)
        .getResultList();
  }

  @Override
  public Course findById(Long id) {
    return entityManager.find(Course.class, id);
  }
}

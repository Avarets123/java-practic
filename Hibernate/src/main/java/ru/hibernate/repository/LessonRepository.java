package ru.hibernate.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import java.util.List;
import lombok.RequiredArgsConstructor;
import ru.hibernate.models.Lesson;

@RequiredArgsConstructor
public class LessonRepository implements CrudRepository<Lesson> {

  private final EntityManager entityManager;

  @Override
  public void save(Lesson entity) {
    EntityTransaction transaction = entityManager.getTransaction();
    transaction.begin();
    entityManager.persist(entity);
    transaction.commit();
  }

  @Override
  public List<Lesson> findAll() {
    return entityManager
        .createQuery("select lesson from Lesson lesson", Lesson.class)
        .getResultList();
  }

  @Override
  public Lesson findById(Long id) {
    return entityManager.find(Lesson.class, id);
  }
}

package ru.web.firstwebapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.web.firstwebapp.models.Course;
import ru.web.firstwebapp.models.Lesson;

import java.util.List;

public interface LessonsRepository extends JpaRepository<Lesson, Long> {
    List<Lesson> findAllByCourse_Id (Long id);

    List<Lesson> findAllByCourseIsNotContaining(Course course);
}

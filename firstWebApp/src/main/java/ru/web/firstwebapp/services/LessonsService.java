package ru.web.firstwebapp.services;

import ru.web.firstwebapp.dto.LessonForm;
import ru.web.firstwebapp.models.Lesson;

import java.util.List;

public interface LessonsService {

    void addLessonInCourse(Long lessonId, Long courseId);

    List<Lesson> findAll();

    List<Lesson> findAllByCourseIsNotContaining(Long id);

    void addLesson(LessonForm lesson);

    List<Lesson> findByCourse_Id(Long id);

    List<Lesson> getAllLessons();

    void deleteLesson(Long id);

    Lesson getLesson(Long id);

    void updateLesson(Long id, LessonForm lessonForm);
}

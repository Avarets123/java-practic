package ru.web.firstwebapp.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.web.firstwebapp.dto.LessonForm;
import ru.web.firstwebapp.models.Course;
import ru.web.firstwebapp.models.Lesson;
import ru.web.firstwebapp.repositories.CoursesRepository;
import ru.web.firstwebapp.repositories.LessonsRepository;
import ru.web.firstwebapp.services.LessonsService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LessonsServiceImpl implements LessonsService {

    private final LessonsRepository lessonsRepository;
    private final CoursesRepository coursesRepository;

    @Override
    public void addLessonInCourse(Long lessonId, Long courseId) {
        Lesson lesson = lessonsRepository.findById(lessonId).orElseThrow();
        Course course = coursesRepository.findById(courseId).orElseThrow();

        lesson.setCourse(course);

        lessonsRepository.save(lesson);
    }

    @Override
    public  List<Lesson> findAll() {
        return lessonsRepository.findAll();
    }

    @Override
    public List<Lesson> findAllByCourseIsNotContaining(Long id) {

        Course course = coursesRepository.findById(id).orElseThrow();

        return lessonsRepository.findAllByCourseIsNotContaining(course);
    }

    @Override
    public void addLesson(LessonForm lesson) {
        Lesson newLesson = Lesson.builder()
                .name(lesson.getName())
                .description(lesson.getDescription())
                .startTime(lesson.getStartTime())
                .finishTime(lesson.getFinishTime())
                .build();

        lessonsRepository.save(newLesson);

    }

    @Override
    public List<Lesson> findByCourse_Id(Long id) {
        return lessonsRepository.findAllByCourse_Id(id);
    }



    @Override
    public List<Lesson> getAllLessons() {
        return lessonsRepository.findAll();
    }

    @Override
    public void deleteLesson(Long id) {
        lessonsRepository.deleteById(id);
    }

    @Override
    public Lesson getLesson(Long id) {
        return lessonsRepository.findById(id).orElseThrow();
    }

    @Override
    public void updateLesson(Long id, LessonForm lessonForm) {
        Lesson lesson = lessonsRepository.findById(id).orElseThrow();

        lesson.setFinishTime(lessonForm.getFinishTime());
        lesson.setStartTime(lesson.getStartTime());
        lesson.setName(lessonForm.getName());
        lesson.setDescription(lessonForm.getDescription());

        lessonsRepository.save(lesson);
    }
}

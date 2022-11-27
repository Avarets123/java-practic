package ru.web.firstwebapp.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.web.firstwebapp.models.Course;
import ru.web.firstwebapp.models.User;
import ru.web.firstwebapp.repositories.CoursesRepository;
import ru.web.firstwebapp.repositories.UserRepository;
import ru.web.firstwebapp.services.CoursesService;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CoursesServiceImpl implements CoursesService {

    private final CoursesRepository coursesRepository;
    private final UserRepository userRepository;



    @Override
    public void addStudentToCourse(Long courseId, Long studentId) {

        User student = userRepository.findById(studentId).orElseThrow();
        Course course = coursesRepository.findById(courseId).orElseThrow();

        student.getCourses().add(course);

        userRepository.save(student);

    }

    @Override
    public Course getCourse(Long courseId) {
        return coursesRepository.findById(courseId).orElseThrow();
    }

    @Override
    public List<User> getNotInCoursesStudents(Long courseId) {
        Course course = coursesRepository.findById(courseId).orElseThrow();
        return userRepository.findAllByCoursesNotContains(course);
    }

    @Override
    public List<User> getInCoursesStudents(Long courseId) {
        Course course = coursesRepository.findById(courseId).orElseThrow();
        return userRepository.findAllByCoursesContains(course);
    }
}

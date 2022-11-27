package ru.web.firstwebapp.services;

import ru.web.firstwebapp.models.Course;
import ru.web.firstwebapp.models.User;

import java.util.List;

public interface CoursesService {

    void addStudentToCourse(Long courseId, Long studentId);

    Course getCourse(Long courseId);

    List<User> getNotInCoursesStudents(Long courseId);

    List<User> getInCoursesStudents(Long courseId);
}

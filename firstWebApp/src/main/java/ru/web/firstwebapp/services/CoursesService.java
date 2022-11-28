package ru.web.firstwebapp.services;

import ru.web.firstwebapp.dto.CourseForm;
import ru.web.firstwebapp.models.Course;
import ru.web.firstwebapp.models.User;

import java.util.List;

public interface CoursesService {

    void addCourse(CourseForm course);

    List<Course> getAllCourses();

    void deleteCourse(Long id);

    void addStudentToCourse(Long courseId, Long studentId);

    Course getCourse(Long courseId);

    List<User> getNotInCoursesStudents(Long courseId);

    List<User> getInCoursesStudents(Long courseId);
}

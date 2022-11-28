package ru.web.firstwebapp.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.web.firstwebapp.dto.CourseForm;
import ru.web.firstwebapp.services.CoursesService;
import ru.web.firstwebapp.services.LessonsService;

@RequiredArgsConstructor
@Controller
public class CoursesController {

    private final CoursesService coursesService;
    private final LessonsService lessonsService;


    @GetMapping("/courses")
    public String getCoursesPage(Model model) {
        model.addAttribute("courses", coursesService.getAllCourses());
        return "courses_page";
    }

    @PostMapping("/courses")
    public String addCourse(CourseForm course) {
        coursesService.addCourse(course);
        return "redirect:/courses";
    }


    @PostMapping("/courses/{id}/students")
    public String addStudentToCourse(@PathVariable("id") Long courseId, @RequestParam("student-id") Long studentId) {
        coursesService.addStudentToCourse(courseId, studentId);
        return "redirect:/courses/" + courseId;
    }

    @GetMapping("/courses/{id}")
    public String getCoursePage(@PathVariable("id") Long courseId, Model model) {
        model.addAttribute("course", coursesService.getCourse(courseId));
        model.addAttribute("notInCourseStudents", coursesService.getNotInCoursesStudents(courseId));
        model.addAttribute("inCourseStudents", coursesService.getInCoursesStudents(courseId));
        model.addAttribute("allLessons", lessonsService.findAll());
        model.addAttribute("lessonsInCourse", lessonsService.findByCourse_Id(courseId));
        return "course_page";
    }


    @PostMapping("/courses/{id}/lesson")
    public String addLesson(@PathVariable("id") Long courseId, @RequestParam("lesson-id") Long lessonId) {
        lessonsService.addLessonInCourse(lessonId, courseId);
        return "redirect:/courses/" + courseId;
    }


    @GetMapping("/courses/{id}/delete")
    public String deleteCourse(@PathVariable("id") Long courseId) {
        coursesService.deleteCourse(courseId);
        return "redirect:/courses";
    }

}

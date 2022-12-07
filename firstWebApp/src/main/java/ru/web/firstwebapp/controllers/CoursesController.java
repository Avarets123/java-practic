package ru.web.firstwebapp.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.web.firstwebapp.dto.CourseForm;
import ru.web.firstwebapp.models.Course;
import ru.web.firstwebapp.security.details.CustomUserDetails;
import ru.web.firstwebapp.services.CoursesService;
import ru.web.firstwebapp.services.LessonsService;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/courses")
public class CoursesController {

    private final CoursesService coursesService;
    private final LessonsService lessonsService;


    @GetMapping
    public String getCoursesPage(@AuthenticationPrincipal CustomUserDetails customUserDetails, Model model) {
        model.addAttribute("courses", coursesService.getAllCourses());
        model.addAttribute("role", customUserDetails.getUser().getRole());
        model.addAttribute("courses",
                List.of(
                        Course.builder().id(1L).title("Java").build(),
                        Course.builder().id(2L).title("SQL").build(),
                        Course.builder().id(3L).title("Spring").build()
                ));
        return "courses_page";
    }

    @PostMapping
    public String addCourse(CourseForm course) {
        coursesService.addCourse(course);
        return "redirect:/courses";
    }


    @PostMapping("/{id}/students")
    public String addStudentToCourse(@PathVariable("id") Long courseId, @RequestParam("student-id") Long studentId) {
        coursesService.addStudentToCourse(courseId, studentId);
        return "redirect:/courses/" + courseId;
    }

    @GetMapping("/{id}")
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


    @GetMapping("/{id}/delete")
    public String deleteCourse(@PathVariable("id") Long courseId) {
        coursesService.deleteCourse(courseId);
        return "redirect:/courses";
    }

}

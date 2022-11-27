package ru.web.firstwebapp.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.web.firstwebapp.services.CoursesService;

@RequiredArgsConstructor
@Controller
public class CoursesController {

    private final CoursesService coursesService;

    @PostMapping("/courses/{id}/students")
    public String addStudentToCourse(@PathVariable("id") Long courseId, @RequestParam("student-id") Long studentId ) {
        coursesService.addStudentToCourse(courseId, studentId);
        return "redirect:/courses/" + courseId;
    }

    @GetMapping("/courses/{id}")
    public String getCoursePage(@PathVariable("id") Long courseId, Model model) {
        model.addAttribute("course", coursesService.getCourse(courseId));
        model.addAttribute("notInCourseStudents", coursesService.getNotInCoursesStudents(courseId));
        model.addAttribute("inCourseStudents", coursesService.getInCoursesStudents(courseId));
        return "course_page";
    }

}

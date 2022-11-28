package ru.web.firstwebapp.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.web.firstwebapp.dto.LessonForm;
import ru.web.firstwebapp.services.LessonsService;

@RequiredArgsConstructor
@Controller
public class LessonsController {

    private final LessonsService lessonsService;

    @GetMapping("/lessons")
    public String getLessons(Model model) {
        model.addAttribute("lessons", lessonsService.getAllLessons());
        return "lessons_page";
    }

    @PostMapping("/lessons")
    public String addLesson(LessonForm lessonForm) {
        lessonsService.addLesson(lessonForm);
        return "redirect:/lessons";
    }

    @GetMapping("/lessons/{id}")
    public String getLesson(@PathVariable("id") Long id, Model model) {
        model.addAttribute("lesson", lessonsService.getLesson(id));
        return "lesson_page";
    }

    @GetMapping("/lessons/{id}/delete")
    public String getLesson(@PathVariable("id") Long id) {
        lessonsService.deleteLesson(id);
        return "redirect:/lessons";
    }

    @PostMapping("/lessons/{id}/update")
    public String updateLesson(@PathVariable("id") Long id, LessonForm lessonForm) {
        lessonsService.updateLesson(id, lessonForm);
        return "redirect:/lessons/" + id;
    }
}

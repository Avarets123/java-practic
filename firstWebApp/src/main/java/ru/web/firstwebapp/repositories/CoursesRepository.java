package ru.web.firstwebapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.web.firstwebapp.models.Course;

public interface CoursesRepository extends JpaRepository<Course, Long> {}

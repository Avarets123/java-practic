package ru.web.firstwebapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.web.firstwebapp.models.Course;
import ru.web.firstwebapp.models.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAllByStateNot(User.State state);

    List<User> findAllByCoursesNotContains(Course course);

    List<User> findAllByCoursesContains(Course course);

}

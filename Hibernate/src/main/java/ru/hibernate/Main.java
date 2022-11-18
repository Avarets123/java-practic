package ru.hibernate;

import jakarta.persistence.EntityManager;
import java.time.LocalDate;
import java.time.LocalTime;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.hibernate.models.Course;
import ru.hibernate.models.Lesson;
import ru.hibernate.models.Student;
import ru.hibernate.repository.CourseRepository;
import ru.hibernate.repository.LessonRepository;
import ru.hibernate.repository.StudentRepository;

public class Main {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.configure("hibernate/hibernate.cfg.xml");
    SessionFactory sessionFactory = configuration.buildSessionFactory();

    EntityManager entityManager = sessionFactory.createEntityManager();

    CourseRepository courseRepository = new CourseRepository(entityManager);
    LessonRepository lessonRepository = new LessonRepository(entityManager);
    StudentRepository studentRepository = new StudentRepository(entityManager);


    Course java = Course.builder()
        .description("Курс по Java")
        .start(LocalDate.now())
        .finish(LocalDate.now().plusMonths(6))
        .title("Java")
        .build();

    Course php = Course.builder()
        .title("PHP")
        .start(LocalDate.now())
        .finish(LocalDate.now().plusYears(2))
        .description("PHP course")
        .build();

    Course one = courseRepository.findById(1L);
    Course two = courseRepository.findById(2L);

    Lesson newLesson = Lesson.builder()
        .course(one)
        .name("PHP - 1")
        .startTime(LocalTime.now())
        .finishTime(LocalTime.now().plusHours(3))
        .summary("Backend")
        .build();


    Student student = Student.builder()
        .age(25)
        .firstName("Oleg")
        .lastName("Chirikov")
        .average(5.2)
        .email("ooo@gmail.com")
        .build();



//    courseRepository.save(java);
//    courseRepository.save(php);

//    lessonRepository.save(newLesson);
//      studentRepository.save(student);

    Student student1 = studentRepository.findById(1L);

    student1.getCourses().add(one);
    student1.getCourses().add(two);
    student1.setAge(33);
    one.getStudents().add(student1);
    two.getStudents().add(student1);
    studentRepository.save(student1);


    entityManager.close();
  }
}
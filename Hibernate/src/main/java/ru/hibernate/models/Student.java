package ru.hibernate.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import java.util.Set;
import lombok.*;
import org.hibernate.annotations.Check;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@EqualsAndHashCode(exclude = "courses")
@ToString(exclude = "courses")
public class Student {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(unique = true, nullable = false)
  private String email;

  @Column(name = "first_name")
  private String firstName;

  @Column(name = "last_name")
  private String lastName;

  @Check(constraints = "age > 0 and age <= 120")
  private Integer age;

  private Double average;

  @ManyToMany
  @JoinTable(
      joinColumns = { @JoinColumn(name = "student_id", referencedColumnName = "id") },
      inverseJoinColumns = {@JoinColumn(name = "course_id", referencedColumnName = "id")}
  )
  private Set<Course> courses;
}

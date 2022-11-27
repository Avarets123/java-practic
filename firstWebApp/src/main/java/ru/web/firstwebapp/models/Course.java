package ru.web.firstwebapp.models;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(exclude = {"lessons", "students"})
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(length = 1000)
    private String description;

    private LocalDate start;
    private LocalDate finish;

    @OneToMany(mappedBy = "course", fetch = FetchType.EAGER)
    private Set<Lesson> lessons;

    @ManyToMany(mappedBy = "courses", fetch = FetchType.EAGER)
    private Set<User> students;


}


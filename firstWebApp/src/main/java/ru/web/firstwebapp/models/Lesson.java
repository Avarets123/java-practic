package ru.web.firstwebapp.models;


import lombok.*;

import jakarta.persistence.*;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@EqualsAndHashCode(exclude = "course")
@ToString(exclude = "course")
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @Column(length = 1000)
    private String summary;

    @Column(name = "start_time")
    private LocalTime startTime;

    @Column(name = "finish_time")
    private LocalTime finishTime;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
}


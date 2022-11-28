package ru.web.firstwebapp.dto;

import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CourseForm {

    private String title;

    private String description;

    private LocalDate start;

    private LocalDate finish;
}

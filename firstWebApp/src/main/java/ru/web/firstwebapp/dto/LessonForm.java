package ru.web.firstwebapp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LessonForm {

    private String name;

    private String description;

    private LocalTime startTime;

    private LocalTime finishTime;
}

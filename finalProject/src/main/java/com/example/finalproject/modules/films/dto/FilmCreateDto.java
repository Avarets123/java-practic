package com.example.finalproject.modules.films.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FilmCreateDto {

    private String name;

    private Timestamp day;

    private LocalTime startTime;

    private LocalTime finishTime;

    private Integer amountTicket;
}

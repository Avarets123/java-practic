package ru.inno.education.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {
  private Long id;
  private String email;
  private String password;
  private String first_name;
  private String last_name;
  private Integer age;
  private Boolean isWorker;
  private Double average;
}

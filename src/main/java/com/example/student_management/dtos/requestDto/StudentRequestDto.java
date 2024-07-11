package com.example.student_management.dtos.requestDto;



import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentRequestDto {
    private String firstName;
    private String lastName;
    private String email;
    private String course;
}

package com.example.student_management.dtos.responsedto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class StudentResponseDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String course;
}

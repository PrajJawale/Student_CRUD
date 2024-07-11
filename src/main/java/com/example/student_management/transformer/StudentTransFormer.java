package com.example.student_management.transformer;

import com.example.student_management.dtos.requestDto.StudentRequestDto;
import com.example.student_management.dtos.responsedto.StudentResponseDto;
import com.example.student_management.entity.Student;

public class StudentTransFormer {

    public static Student addStudent(StudentRequestDto studentRequestDto) {
        return Student.builder()
                .firstName(studentRequestDto.getFirstName())
                .lastName(studentRequestDto.getLastName())
                .email(studentRequestDto.getEmail())
                .course(studentRequestDto.getCourse())
                .build();
    }

    public static StudentResponseDto StudentResponse(Student student) {
        return StudentResponseDto.builder()
                .id(student.getId())
                .firstName(student.getFirstName())
                .lastName(student.getLastName())
                .email(student.getEmail())
                .course(student.getCourse())
                .build();
    }

    public static Student updateStudent(StudentRequestDto studentRequestDto) {
        return Student.builder()
                .firstName(studentRequestDto.getFirstName())
                .lastName(studentRequestDto.getLastName())
                .email(studentRequestDto.getEmail())
                .course(studentRequestDto.getCourse())
                .build();
    }
}
